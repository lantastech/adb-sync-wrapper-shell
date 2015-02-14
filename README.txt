"""
Prerequisite
"""
Somewhere place the code to backup database from internal storage to SDCard
and note the file name as well as directory


"""
Installation Instruction
"""

1. Download adb-sync from https://github.com/google/adb-sync
2. Add the path of 'android-sync' folder to `PATH` Environment variable
3. click on sync.cmd/sync.sh in windows/linux system.
4. There will be an output file in the same directory
5. Chill !!!!

"""
Customizations
"""
If you think you need to sync file( Mostly Database ) or a directory
Simply edit the sync.cmd/sync.sh on windows/unix system

There please enter the corresponding path of `DB_Name`( leave it blank , if you want to sync the entire source directory )
Please enter the absolute path of the directory where the file is placed inside `SOURCE_DIR`


