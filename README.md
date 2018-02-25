# leveldb-mcpe-android
Ported Mojang's modified leveldb database to Android.
Used to build Android apps in Android Studio to use leveldb
database.
It's intended to be included in apps to modify Minecraft
game maps, so...
The JNI part of this project has been hard-coded to use
the configuration which is also used by Minecraft
Bedrock Edition (May also be known as MinecraftPE).
Such configuration can't be changed in Java code at least
for now.

## Based on
* [@litl 's repo](https://github.com/litl/android-leveldb)
    Android JNI version of Google's leveldb database, which most of
    codes were copied from :)
* [@Mojang 's modified leveldb](https://github.com/Mojang/leveldb-mcpe)
* and [@Google 's original work](https://github.com/google/leveldb) of course:)

## Usage

Figure it out yourself...\
Well, actually...I don't think anyone would use this thing...
Here's some tips, if you really want more, open an issue to
let me know..

You can download an aar file 
[here](https://github.com/oO0oO0oO0o0o00/leveldb-mcpe-android/releases)
and include it in your Android Studio projects.\
[How to use aar files?](https://www.google.com/search?&q=import+aar+android+studio&oq=import+aar+android+studio)\

If you have ever used com.litl.leveldb you can just stick
to the old ~~rabbit~~ habit:

```java
    //Open database
    DB db = new DB(new File("/sdcard/iloverbq2012"));
    db.open();
    
    //Put key/value pairs
    db.put("test key".getBytes(),new byte[]{2,3,3,3});
    
    //Get value using key
    byte[] result=db.get("test key".getBytes());
    
    //Close database
    db.close();

```

For more you can just exam the demo's
[code](https://github.com/oO0oO0oO0o0o00/leveldb-mcpe-android/blob/master/demo/src/main/java/rbq2012/leveldb/demo/ActivityMain.java)
.

You can also modify the code and compile by yourself.

## How to build the project

Open project in Android Studio, wait until it's finally
ready (Maybe long enough for watching a Redtube video),
click bunches of buttons to download and install various
versions of things if you don't have SDK, Gradle and other
things in exact same version as this project uses installed,
during the time you could check up messages or whatever,
depending on your net speed...

Then you have the project opened now, plug your phone to
computer if you don't have a virtual device created, click
'Run' and wait another decade for Android Studio to compile
java and C++ codes, generate an APK and have it installed on
your phone or emulator...

_(This section does nothing except complaining about how
slow Android Studio is.)_

## Original "Readme"s:
* [@litl 's](https://github.com/litl/android-leveldb/blob/master/README.md)
* [@mojang 's](https://github.com/Mojang/leveldb-mcpe/blob/master/README.md)

### Meow meow meow~~~