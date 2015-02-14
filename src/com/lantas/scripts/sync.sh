ANDROID_PACKAGE_NAME="com.lantas.phonebookbeta"
DB_NAME="backupphonebook.db"
SOURCE_DIR="/sdcard/Android/data/$ANDROID_PACKAGE_NAME/files"
java -jar AndroidDatabaseSync.jar $DB_NAME $SOURCE_DIR
