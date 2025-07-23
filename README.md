# Дипломный проект профессии «Инженер по тестированию»
## Предварительные условия:
1. Установить и открыть Android Studio https://developer.android.com/studio

2. Склонировать репозиторий https://github.com/Baduk98/diplom.git

3. Установить приложение на мобильное устройство/эмулятор.

4. Данные для авторизации: логин: login2; пароль: password2
## Инструкция по запуску
1. Перейти в файл в для проверки тестирования:

```fmh_android_15_03_24/app/src/androidTest/java/ru/iteco/fmhandroid/ui```


2. В терминале выполнить команду:

```adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AuthorizationTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AllTests' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

```adb shell am instrument -w -m    -e debug false -e class 'ru.iteco.fmhandroid.ui.tests.AboutTest' ru.iteco.fmhandroid.test/androidx.test.runner.AndroidJUnitRunner```

