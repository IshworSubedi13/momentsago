package np.com.ishworsubedi.momentsago;

import android.content.Context;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

public class MomentsAgo {
    private static SimpleDateFormat getDefaultFormatter() {
        return new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
    }

    public static String getCurrentDateFormatted() {
        return getDefaultFormatter().format(new Date());
    }

    public static String getRelativeTime(Context context, long timestampMillis) {
        long now = System.currentTimeMillis();
        long diff = now - timestampMillis;

        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        if (seconds < 60) {
            return context.getString(R.string.moment_just_now);
        } else if (minutes < 60) {
            return context.getString(R.string.moment_minutes_ago, minutes);
        } else if (hours < 24) {
            return context.getString(R.string.moment_hours_ago, hours);
        }else if (days == 1) {
                return context.getString(R.string.moment_yesterday);
        } else if (days < 7) {
            return context.getString(R.string.moment_days_ago, days);
        } else if (days < 30) {
            int weeks = (int) (days / 7);
            return context.getString(R.string.moment_weeks_ago, weeks);
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Use java.time for accurate year/month
            LocalDate pastDate = Instant.ofEpochMilli(timestampMillis)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(pastDate, currentDate);

            int years = period.getYears();
            int months = period.getMonths();

            if (years > 0 && months > 0) {
                return context.getString(R.string.moment_years_months_ago, years, months);
            } else if (years > 0) {
                return context.getResources().getQuantityString(R.plurals.moment_years_ago, years, years);
            } else {
                return context.getResources().getQuantityString(R.plurals.moment_months_ago, months, months);
            }
        } else {
            // Fallback for API < 26 using approximate logic
            int approxMonths = (int) (days / 30);
            if (approxMonths < 12) {
                return context.getResources().getQuantityString(R.plurals.moment_months_ago, approxMonths, approxMonths);
            } else {
                int approxYears = approxMonths / 12;
                return context.getResources().getQuantityString(R.plurals.moment_years_ago, approxYears, approxYears);
            }
        }
    }

}
