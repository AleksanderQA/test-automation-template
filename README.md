**Configuration**

1. Open the `src/test/resources/application.yaml` file.
2. Update with your credentials:

    ```yaml
    general:
      username: YOUR_API_KEY_HERE
    ```

**Usage**

```
mvn clean test  
mvn allure:serve 
```

To run a specific test class using Maven, execute the following command in the terminal:

```
mvn clean test -Dtest=TestClassName
```

---

## __HW-17__ - <font color = 'Green'>_Locators_</font> <br> WEB Service: [Link](http://35.208.34.242:3000/signin)

````
1 Составьте чек-лист функциональных проверок UI приложения tallinn delivery в части
логина.
2. Составьте список веб элементов и их локаторов (xpath), необходимых для реализации
   проверок из пункта 1 в виде таблицы
````

### Used google chrome  extension: [Link](https://chromewebstore.google.com/detail/xpath-helper/hgimnogjllphhhkhlmebbmlgjoejdpjl)

### [Xpather](http://xpather.com/)

| № | Element name                                        | XPath                                                                   |
|---|-----------------------------------------------------|-------------------------------------------------------------------------|
| 1 | Username field input                                | //*[@data-name='username-input']                                        |
| 2 | Password field input                                | //*[@data-name='password-input']                                        |
| 3 | Presence of a username entry field                  | //input[@id='username']                                                 |
| 3 | Username enter type is Text                         | //input[@type ='text']                                                  |
| 4 | Presence of a password entry field                  | //input[@id='password']                                                 |
| 4 | Password enter type is Password                     | //input[@type ='password']                                              |
| 5 | Username field limits                               | //input[@name="username" and @minlength >= 2 and @maxlength <= 30]      |
| 5 | Password field limits                               | //input[@name="password" and @minlength >= 8 and @maxlength <= 30]      |
| 5 | Presence of a button Sign in                        | //button[@class='button login__button']                                 |
| 5 | Error Pop-up if entered incorrect credentials       | //*[@*='error-popup__title'][contains(text(), 'Incorrect credentials')] |
| 5 | If entered characters less that 2 in username field | //span[@data-name = 'username-input-error']                             |
| 5 | If entered characters less that 8 in password field | //span[@data-name = 'username-input-error']                             |

``````
3 Дополните readme текущего проектам (с автотестами API) результатами пунктов 1 и 2
4 Для html документа составьте xpath
Пример для 4.2 //tr[starts-with(@data-qa, 'value-')]
4.1 Выбрать все элементы <td>, содержащие имена (Name)
4.2 Выбрать все элементы <tr>, у которых атрибут data-qa начинается с "amount-"
4.3 Выбрать все элементы <tr>, содержащие элемент <td> с текстом "John Doe"
``````

| №   | XPath                              |
|-----|------------------------------------|
| 4.1 | //td[contains(., 'Name')]          |
| 4.2 | //tr/td/p[starts-with(.,'Amount')] |
| 4.3 | //tr/td[contains(., 'John Doe')]   |

<details> <br>
<summary>HTML document spoiler</summary> 

````````
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <meta http-equiv="Content-Style-Type" content="text/css">
  <title>Table Example</title>
  <meta name="Generator" content="Cocoa HTML Writer">
  <meta name="CocoaVersion" content="2113.6">
  <style type="text/css">
    p.p1 {margin: 0.0px 0.0px 0.0px 0.0px; text-align: center; font: 12.0px Times; color: #000000; -webkit-text-stroke: #000000}
    p.p2 {margin: 0.0px 0.0px 0.0px 0.0px; font: 12.0px Times; color: #000000; -webkit-text-stroke: #000000}
    p.p3 {margin: 0.0px 0.0px 0.0px 0.0px; font: 12.0px Times; color: #fb0007; -webkit-text-stroke: #fb0007; min-height: 14.0px}
    span.s1 {font-kerning: none}
    table.t1 {border-style: solid; border-width: 1.0px 1.0px 1.0px 1.0px; border-color: #6d6d6d #6d6d6d #6d6d6d #6d6d6d}
    td.td1 {width: 42.7px; margin: 0.5px 0.5px 0.5px 0.5px; border-style: solid; border-width: 1.0px 1.0px 1.0px 1.0px; border-color: #6d6d6d #6d6d6d #6d6d6d #6d6d6d; padding: 1.0px 1.0px 1.0px 1.0px}
    td.td2 {width: 42.0px; margin: 0.5px 0.5px 0.5px 0.5px; border-style: solid; border-width: 1.0px 1.0px 1.0px 1.0px; border-color: #6d6d6d #6d6d6d #6d6d6d #6d6d6d; padding: 1.0px 1.0px 1.0px 1.0px}
    td.td3 {width: 67.7px; margin: 0.5px 0.5px 0.5px 0.5px; border-style: solid; border-width: 1.0px 1.0px 1.0px 1.0px; border-color: #6d6d6d #6d6d6d #6d6d6d #6d6d6d; padding: 1.0px 1.0px 1.0px 1.0px}
  </style>
</head>
<body>
<table cellspacing="0" cellpadding="0" class="t1">
  <tbody>
    <tr>
      <td valign="middle" class="td1">
        <p class="p1"><span class="s1"><b>Number</b></span></p>
      </td>
      <td valign="middle" class="td2">
        <p class="p1"><span class="s1"><b>Amount</b></span></p>
      </td>
      <td valign="middle" class="td3">
        <p class="p1"><span class="s1"><b>Name</b></span></p>
      </td>
    </tr>
    <tr>
      <td valign="middle" class="td1">
        <p class="p2"><span class="s1">1</span></p>
      </td>
      <td valign="middle" class="td2">
        <p class="p2"><span class="s1">$100.00</span></p>
      </td>
      <td valign="middle" class="td3">
        <p class="p2"><span class="s1">John Doe</span></p>
      </td>
    </tr>
    <tr>
      <td valign="middle" class="td1">
        <p class="p2"><span class="s1">2</span></p>
      </td>
      <td valign="middle" class="td2">
        <p class="p2"><span class="s1">$50.00</span></p>
      </td>
      <td valign="middle" class="td3">
        <p class="p2"><span class="s1">Jane Smith</span></p>
      </td>
    </tr>
    <tr>
      <td valign="middle" class="td1">
        <p class="p2"><span class="s1">3</span></p>
      </td>
      <td valign="middle" class="td2">
        <p class="p2"><span class="s1">$75.00</span></p>
      </td>
      <td valign="middle" class="td3">
        <p class="p2"><span class="s1">Mike Johnson</span></p>
      </td>
    </tr>
    <tr>
      <td valign="middle" class="td1">
        <p class="p2"><span class="s1">4</span></p>
      </td>
      <td valign="middle" class="td2">
        <p class="p2"><span class="s1">$120.00</span></p>
      </td>
      <td valign="middle" class="td3">
        <p class="p2"><span class="s1">Susan Lee</span></p>
      </td>
    </tr>
  </tbody>
</table>
<p class="p3"><span class="s1"></span><br></p>
</body>
</html>
table.html
Displaying table.html.
````````

</details> <br>