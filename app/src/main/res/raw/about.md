# Hello world!

I actually enjoys doing android development, it is better than flutter in that android
is a complete solution to Android apps.
This AnTodo application is crated by Zhang Xiukai with ❤️.

![how-about-gifs?](https://face.zhaoxi.org/upload/201208/21/2.03142464.gif)

## Requirements

- [x] 5+ Activities
- [x] Custom ListView
- [X] Sqlite

## Basic modern app dev

**layers**

1. UI Layer
2. Domain Layer
3. Dat Layer

## App environment

Every android app has its own Linux user id.
The OS uses this user id to assign access permissions.
If two apps have the same user id, they can share files.
Every app can request the permission to use a specific system function, like GPS.

## Basic architecture of android

**Four components**

- Activity: is an activity
- Service: non-visible function components of the app, e.g. download service
- Broadcast: react to system broadcasts
- Content Provider: access data

**binding**
A binding is basically something facilitates program expression.
Data binding and view binding are two types of bindings in Android.

## References

This page is written in markdown and rendered with [Markwon](https://github.com/noties/Markwon).
The launcher icon is generated with Image Asset Studio.

- [Android Docs - manifest-intro](https://developer.android.com/guide/topics/manifest/manifest-intro)
- [Android Docs - Intent](https://developer.android.com/reference/android/content/Intent)
- [Android Docs - Button](https://developer.android.com/reference/android/widget/Button)
- [Android Docs - intro-activities](https://developer.android.com/guide/components/activities/intro-activities)
- [Android Docs - fundamentals](https://developer.android.com/guide/components/fundamentals)
- [Android Docs - architecture](https://developer.android.com/topic/architecture)
- [Android Docs - fragments](https://developer.android.com/guide/fragments)
- [Android Docs - view-binding](https://developer.android.com/topic/libraries/view-binding)
- [Android Docs - data-binding](https://developer.android.com/topic/libraries/data-binding)
- [Android Docs - menus](https://developer.android.com/develop/ui/views/components/menus)
- [Android Docs - data-storage/room](https://developer.android.com/training/data-storage/room)
- [Android Docs - data-storage/shared-preferences](https://developer.android.com/training/data-storage/shared-preferences)
- [Android Docs - processes-and-threads](https://developer.android.com/guide/components/processes-and-threads)
- [Android Docs - UI Guide - settings](https://developer.android.com/develop/ui/views/components/settings)
- [Android Docs - settings-guidelines](https://source.android.com/devices/tech/settings/settings-guidelines)
- [Android Docs - androidx/preference](https://developer.android.com/reference/androidx/preference/package-summary)
- [Android Docs - appbar](https://developer.android.com/develop/ui/views/components/appbar)
- [Android Docs - darktheme](https://developer.android.com/develop/ui/views/theming/darktheme)
- [Android Docs - viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [Android Docs - image-asset-studio](https://developer.android.com/studio/write/image-asset-studio)
- [Android Docs - timer](https://developer.android.com/reference/java/util/Timer)
- [Android Docs - providing-resources](https://developer.android.com/guide/topics/resources/providing-resources)
- [Android Docs - Resources](https://developer.android.com/reference/android/content/res/Resources)
- [Android Docs - jdk - InputStream](https://developer.android.com/reference/java/io/InputStream)
- [Android Docs - jdk - navigation-getting-started](https://developer.android.com/guide/navigation/navigation-getting-started)
- [Android Docs - navigation-pass-data](https://developer.android.com/guide/navigation/navigation-pass-data)
- [Android Docs - navigation-global-action](https://developer.android.com/guide/navigation/navigation-global-action)
- [Gradle docs - centralized-repository-declaration](https://docs.gradle.org/7.4.2/userguide/dependency_management.html#sub:centralized-repository-declaration)
- [Android Dev Summit 18 - Single activity: Why, when, and how (Android Dev Summit '18)](https://www.youtube.com/watch?v=2k8x8V77CrU)
- [sqlite.org - datatype3](https://www.sqlite.org/datatype3.html)
- [Dev.to - declarative-vs-imperative](https://dev.to/ruizb/declarative-vs-imperative-4a7l)
- [Wikipedia - domain](https://en.wikipedia.org/wiki/Domain_(software_engineering))
- [Wikipedia - domain model](https://en.wikipedia.org/wiki/Domain_model)
- [Wikipedia - domain model](https://en.wikipedia.org/wiki/Domain_model)
- [stackoverflow - restrict-edittext-to-single-line](https://stackoverflow.com/questions/10978038/restrict-edittext-to-single-line)
- [stackoverflow - how-to-set-minimum-datepicker-date-to-current-date](https://stackoverflow.com/questions/13661788/how-to-set-minimum-datepicker-date-to-current-date)
- [stackoverflow - mvvm-rxandroid-cannot-invoke-setvalue-on-a-background-thread](https://stackoverflow.com/questions/53999701/mvvm-rxandroid-cannot-invoke-setvalue-on-a-background-thread)
- [stackoverflow - android-dark-mode-my-menu-text-is-black-on-dark-gray-why-is-that-so](https://stackoverflow.com/questions/69595236/android-dark-mode-my-menu-text-is-black-on-dark-gray-why-is-that-so)
- [stackoverflow - arrayadapter-in-fragment-android](https://stackoverflow.com/questions/25922451/arrayadapter-in-fragment-android)
- [stackoverflow - adding-a-listview-in-a-fragment](https://stackoverflow.com/questions/69164648/adding-a-listview-in-a-fragment)
- [stackoverflow - how-do-i-read-convert-an-inputstream-into-a-string-in-java](https://stackoverflow.com/questions/309424/how-do-i-read-convert-an-inputstream-into-a-string-in-java)
- [Digital Ocean - android-textinputlayout-example](https://www.digitalocean.com/community/tutorials/android-textinputlayout-example)
- [Qiita - Android で Singleton を使う場合の注意点](https://qiita.com/ishihatta/items/827ccd361b74d4c270cd)
- [android.keicode.com - ListView の基本的な使い方](https://android.keicode.com/basics/ui-listview.php)
- [cnblogs - Android杂谈ListView之ArrayAdapter的使用](https://www.cnblogs.com/loulijun/archive/2011/12/26/2302287.html)
- [Dieter Bremes Blog - data-binding-android-listviews](https://dbremes.wordpress.com/2017/11/12/data-binding-android-listviews/)
- Schildt H, Coward D. Java: the complete reference[M] Chapter 7 varargs. New York: McGraw-Hill
  Education, 2014.