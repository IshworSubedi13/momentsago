
# 📱 MomentsAgo

**MomentsAgo** is a lightweight Android library for converting timestamps into human-readable "time ago" strings like “5 minutes ago”, “Yesterday”, or “2 days ago”. Ideal for social feeds, logs, or chat apps.

---

## ✨ Features

- 🕒 Converts timestamps to readable relative time
- 🧩 Lightweight and dependency-free
- 📦 Easy to integrate into Android projects
- 🌐 Supports localization (with simple string tweaks)

---

## 📦 Installation

### Step 1: Add JitPack to your root `build.gradle`
```groovy
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```

### Step 2: Add the library dependency
```groovy
dependencies {
    implementation 'com.github.IshworSubedi13:momentsago:1.0.0'
}
```

> 🔖 Replace `1.0.0` with the latest [release version](https://github.com/IshworSubedi13/momentsago/releases)

---

## 🛠 Usage

### Java
```java
String timeAgo = MomentsAgo.getTimeAgo(System.currentTimeMillis());
textView.setText(timeAgo);  // e.g., "Just now"
```

### Kotlin
```kotlin
val timeAgo = MomentsAgo.getTimeAgo(System.currentTimeMillis())
textView.text = timeAgo
```

### With custom timestamp
```java
long timestamp = yourDate.getTime(); // milliseconds
String result = MomentsAgo.getTimeAgo(timestamp);
```

---

## 🧪 Sample Output
Just now        
2 minutes ago         
1 hour ago              
Yesterday                  
5 days ago                 

---

## 🚀 Demo

Want to try it? Clone the repo and run the sample Android project included.

```bash
git clone https://github.com/IshworSubedi13/momentsago.git
cd momentsago
```

---

## 🤝 Contributing

Contributions, pull requests, and bug reports are welcome!

1. Fork this repository
2. Create your feature branch: `git checkout -b feature/new-feature`
3. Commit your changes: `git commit -am 'Add new feature'`
4. Push to the branch: `git push origin feature/new-feature`
5. Open a pull request

---

## 📄 License

This project is licensed under the MIT License.  See the [LICENSE](LICENSE) file for more info.

---

## 🙋‍♂️ Author

Developed with ❤️ by [Ishwor Subedi](https://ishworsubedi.com.np)

---

## ⭐ Support

If you like this project, please consider starring the repo 🌟 and sharing it.
