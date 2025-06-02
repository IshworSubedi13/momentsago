package np.com.ishworsubedi.momentsago;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        long pastTimestamp = System.currentTimeMillis() - (1000L * 60 * 60 * 24 * 3225); // 45 minutes ago
        String message = MomentsAgo.getRelativeTime(this, pastTimestamp);
        System.out.println(message);


    }
}