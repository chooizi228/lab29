## Cодержание

1. [Отчет по лабораторной работе № N](#отчет-по-лабораторной-работе--n)

## Отчет по лабораторной работе № 1

#### № группы: `ПМ-2402`

#### Выполнил: `Чижевская Софья Петровна`

#### Вариант: `29`

### Cодержание:

- [Постановка задачи](#1-постановка-задачи)
- [Входные и выходные данные](#2-входные-и-выходные-данные)
- [Математическая модель](#25-математическая-модель)
- [Выбор структуры данных](#3-выбор-структуры-данных)
- [Алгоритм](#4-алгоритм)
- [Программа](#5-программа)
- [Анализ правильности решения](#6-анализ-правильности-решения)

### 1. Постановка задачи

- Условие

> На вход программы подается четыре различных целых числа. Вывести на
экран разность максимального неположительного и минимального неотрицательного числа.


- Данная задача требует проверки введённых чисел на наличие неотрицательных и неположительных.
  Если отсутствуют и те и другие, то код прекратит работу. Если есть неотрицательные и неположительные
  целые числа, то мы найдём разность максимального неположительного и минимального неотрицательного.

### 2. Входные и выходные данные

#### Данные на вход

На вход программа получает 4 различных целых (по условию) числа. В условии не сказано про
нижние и верхние границы. Из этого мы можем сделать вывод, что нашей областью значений
являются все целые числа.

|              | Тип                  | min значение | max значение |
|--------------|----------------------|--------------|--------------|
| X1 (Число 1) | Целочисленное число  | -            | -            |
| X2 (Число 2) | Целочисленное число  | -            | -            |
| X3 (Число 3) | Целочисленное число  | -            | -            |
| X4 (Число 4) | Целочисленное число  | -            | -            |

#### Данные на выход

Т.к. программа должна вывести разность максимального неотрицательного и минимального неположительного,
то на выходе мы получим одно целочисленное отрицательное число.

|         | Тип                                 | min значение | max значение |
|---------|-------------------------------------|--------------|--------------|
| Число 1 | Целочисленное неотрицательное число | -            | -1           |

### 3. Выбор структуры данных

Программа получает 4 целочисленных числа. Поэтому для их хранения
можно выделить 4 переменных (`x`, `x2`, `x3`, `x4`) типа `int`.

|              | название переменной | Тип (в Java) | 
|--------------|---------------------|--------------|
| X (Число 1)  | `x1`                | `int`        |
| X2 (Число 2) | `x2`                | `int`        |
| X3 (Число 3) | `x3`                | `int`        |
| X4 (Число 4) | `x4`                | `int`        | 

Для вывода результата необязательно его хранить в отдельной переменной.

### 4. Алгоритм

#### Алгоритм выполнения программы:
```mermaid
graph TD
    A([Начало]) --> B[/Ввести: x1, x2, x3, x4/]
    B --> C{x1 =< 0}
    C -- Да --> D[max=x1 isMax=true]
    C -- Нет --> E
    D --> E{x1 => 0}
    E -- Да --> F[min=x1 isMin=true]
    E -- Нет --> C2
    F --> C2{x2 =< 0}
    
    C2 -- Да --> D2{!isMax//x2>max}
    C2 -- Нет --> E2{x2 => 0}
    D2 -- Да--> G2[max=x2 isMax=true]
    D2 -- Нет--> E2
    G2 --> E2
    E2 -- Да --> H2{!isMin//x2<min}
    E2 -- Нет --> C3{x3 =< 0}
    H2 -- Да--> I2[min=x2 isMin=true]
    H2 -- Нет--> C3
    I2 --> C3

    C3 -- Да --> D3{!isMax//x3>max}
    C3 -- Нет --> E3{x3 => 0}
    D3 -- Да--> G3[max=x3 isMax=true]
    D3 -- Нет--> E3
    G3 --> E3
    E3 -- Да --> H3{!isMin//x3<min}
    E3 -- Нет --> C4{x4 =< 0}
    H3 -- Да--> I3[min=x3 isMin=true]
    H3 -- Нет--> C4
    I3 --> C4

    C4 -- Да --> D4{!isMax//x4>max}
    C4 -- Нет --> E4{x4 => 0}
    D4 -- Да--> G4[max=x4 isMax=true]
    D4 -- Нет--> E4
    G4 --> E4
    E4 -- Да --> H4{!isMin//x4<min}
    E4 -- Нет --> C5{!isMax}
    H4 -- Да--> I4[min=x4 isMin=true]
    H4 -- Нет--> C5
    I4 --> C5
    C5 -- Да --> D5[/Нет неположительных чисел/]
    C5 -- Нет --> С6{!isMin}
    С6 -- Да --> D6[/Нет неотрицательных чисел/]
    С6 -- Нет --> D7[/Вывести max-min/]
    D5 -->C7(Конец)
    D6 -->C7
    D7 -->C7
```

### 5. Программа
```java
import java.io.PrintStream;
import java.util.Scanner;
public class Main {
    // Объявляем объект класса Scanner для ввода данных
    public static Scanner in = new Scanner(System.in);
    // Объявляем объект класса PrintStream для вывода данных
    public static PrintStream out = System.out;
    public static void main(String[] args) {
        out.println("Введите четыре числа");
        // Считывание четырех целых чисел x1 x2 x3 x4 из консоли
        int x1 = in.nextInt();
        int x2 = in.nextInt();
        int x3 = in.nextInt();
        int x4 = in.nextInt();
        int min = 0;
        int max = 0;
        boolean isMax=false;
        boolean isMin=false;
        //Проверяем каждое введённое число на положительность и отрицательность

        if (x1<=0)//x1 неположительное
        {//Если x1 неположительное, то заносим его в переменную max
            max=x1;
            isMax=true;
        }
        if (x1>=0)//x1 неотрицательное
        {//Если x1 неотрицательное, то заносим его в переменную min
            min=x1;
            isMin=true;
        }
        if (x2<=0)//x2 неположительное
        {//Если x2 неположительное и х2 больше, чем максимальное неположительное, то заносим его в переменную max
            if (!isMax || x2>max){
                max=x2;
                isMax=true;
            }
        }
        if (x2>=0)//x2 неотрицательное
        {//Если x2 неотрицательное и х2 меньше, чем максимальное неположительное, то заносим его в переменную min
            if (!isMin || x2<min){
                min=x2;
                isMin=true;
            }
        }
        if (x3<=0)//x3 неположительное
        {//Если x3 неположительное и х3 больше, чем максимальное неположительное, то заносим его в переменную max
            if (!isMax || x3>max){
                max=x3;
                isMax=true;
            }
        }
        if (x3>=0)//x3 неотрицательное
        {//Если x3 неотрицательное и х3 меньше, чем максимальное неположительное, то заносим его в переменную min
            if (!isMin || x3<min){
                min=x3;
                isMin=true;
            }
        }
        if (x4<=0)//x4 неположительное
        {//Если x4 неположительное и х4 больше, чем максимальное неположительное, то заносим его в переменную max
            if (!isMax || x4>max){
                max=x4;
                isMax=true;
            }
        }
        if (x4>=0)//x4 неотрицательное
        {//Если x4 неотрицательное и х4 меньше, чем максимальное неположительное, то заносим его в переменную min
            if (!isMin || x4<min){
                min=x4;
                isMin=true;
            }
        }
        if (!isMax){//Если отсутствуют неположительные числа
            out.println("Нет неположительных чисел");
        }
        else  if (!isMin){//Если отсутствуют неотрицательные числа
            out.println("Нет неотрицательных чисел");
        }
        else{//Если есть и те и те числа, то выводим результат
            out.println("Разность максимального неположительного и минимального неотрицательного:");
            out.println(max-min);
        }
    }
}
```
### 6. Анализ правильности решения

Программа работает корректно на всем множестве решений с учетом ограничений.

1. Тест на `x1 <= 0, x2 <= 0, x2 <= 0, x2 <= 0`:

    - **Input**:
        ```
        -5 -4 -3 -1
        ```

    - **Output**:
        ```
        Нет неотрицательных чисел
        ```

2. Тест на `x1 >= 0, x2 >= 0, x2 >= 0, x2 >= 0`:

    - **Input**:
        ```
        5 4 3 1
        ```

    - **Output**:
        ```
        Нет неположительных чисел
        ```

3. Тест на `x1 >= 0, x2 <= 0, x3 >= 0, x4 <= 0 `:

    - **Input**:
        ```
        21 -15 13 -2
        ```

    - **Output**:
        ```
        -15
        ```