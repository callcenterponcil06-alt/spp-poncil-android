CARA MENDAPATKAN APK OTOMATIS

1. Ekstrak ZIP ini.
2. Buat repository baru di https://github.com dan unggah seluruh ISI folder proyek ini ke repository (bukan folder luarnya).
3. Pastikan file .github/workflows/build-apk.yml ikut terunggah.
4. Buka tab Actions di repository GitHub.
5. Pilih workflow "Build Android APK", lalu tekan Run workflow. Jika unggah ke branch main/master, build juga berjalan otomatis.
6. Tunggu sampai proses berstatus hijau (berhasil).
7. Buka hasil run workflow, bagian Artifacts, lalu unduh android-apk. Di dalam ZIP artifact terdapat app-debug.apk.

Catatan:
- Build dilakukan oleh GitHub Actions; ZIP proyek ini sendiri bukan file APK.
- APK debug dapat dipasang untuk pengujian. Untuk distribusi publik/Play Store, perlu APK release yang ditandatangani dengan keystore.
- Jika build gagal, buka log workflow dan kirimkan pesan errornya agar bisa diperbaiki.
