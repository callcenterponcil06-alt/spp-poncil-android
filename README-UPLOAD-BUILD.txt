PANDUAN UPLOAD DAN BUILD APK

1. Ekstrak ZIP ini. Buka folder proyek di dalamnya.
2. Upload ISI folder proyek ke root repository GitHub (jangan upload ZIP).
3. Pastikan folder .github/workflows ikut ter-upload. Di dalamnya harus ada build-apk.yml.
4. Folder app, file build.gradle, settings.gradle, dan gradle.properties juga harus ada di root repository.
5. Tidak perlu folder gradle atau file gradlew/gradlew.bat untuk paket ini. Workflow memasang Gradle 8.9 sendiri di GitHub Actions.
6. Setelah upload, buka tab Actions > Build Android APK > Run workflow.
7. Jika sukses, buka hasil run dan unduh artifact bernama android-apk.

Catatan: ini proyek Android WebView. APK belum dikompilasi di sini.
