# Тестовое задание. Android. SHIFT lab CFT
## Требования
1. Допускаются языки: Kotlin, Java.
2. Исходный код выполненного задания должен быть размещен в git репозитории
3. Проект должен собираться и запускаться.
4. Будет большим плюсом если вы будете следовать принципам SOLID, Clean Architecture и придерживаться
паттерна MVVM или MVI.
## Экран 1. Регистрация
1. На экране находится 6 элементов:
1. Поля для ввода имени и фамилии.
2. Поле для ввода даты рождения.
3. Поля для ввода пароля и его подтверждения.
4. Кнопка «Регистрация».
2. «Регистрация» не может быть завершена, пока все данные не будут валидны. Правила для корректных
данных придумайте сами. Например, фамилия не может содержать менее двух символов, пароль должен
содержать цифры и буквы верхнего регистра, и т.д.
3. Если данные валидны, то мы переходим на «Главный экран» приложения.
## Экран 2. Главный экран
1. На экране 1 элемент — кнопка «Приветствие».
2. По нажатию на эту кнопку появляется модальное окно, в котором находится приветствие пользователя с
указанием имени, которое было введено на самом первом экране регистрации.
## * Необязательно
1. Сделать выбор даты рождения интерактивным
2. Уведомлять/показывать сообщение о том, где именно была допущена ошибка при «Регистрации».
3. Кнопка «Регистрация» должна быть недоступна для нажатия, пока все поля не будут заполнены.
4. Реализовать кеширование данных и сохранение сессии: если пользователь единожды прошёл
регистрацию, то следующий запуск приложения будет начинаться с главного экрана.

## UseCase Диаграммы
![ShiftTestTask(app,domain,data)](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/2ddb2993-f526-4108-9aa1-469b3735a634)

## Демонстрация работы
### Регистрация
![cfttesttask1](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/0ad2c7a8-f28f-440b-8e96-87c0b7d574e1)
### Неправильные данные в полях
![cfttesttask2](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/3b95c93a-97e8-4aec-acee-0b247002c346)
### Правильные данные в полях
![cfttesttask3](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/4f4cc73c-7963-4516-bbf7-0fc6536db0aa)
### Интерактивный календарь
![cfttesttask6](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/f05fe278-995b-4cb3-8156-861084ca7b0c)
### Главный экран
![cfttesttask4](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/082720b8-0c0e-4714-a77b-11d6b5ae8770)
### Приветствие пользователя
![cfttesttask5](https://github.com/RMashkalev/ShiftTestTask/assets/78581660/d13af4f5-ef62-4d13-9d0b-48bb52bb3438)

