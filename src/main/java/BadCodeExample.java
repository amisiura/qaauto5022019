
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;


public class BadCodeExample {

    public static void main(String[] args) {
        /*System.out.println("Hello world");*/
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\misiura_o\\IdeaProjects\\qaauto5022019\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); /* объявление переменной (имя - driver, тип - Webdriver) и задание значения - создание нового объекта хром драйвера, new - создание нового объекта */
        driver.get("https://www.google.com");// переходим на заданную страницу
        WebElement searchField = driver.findElement(By.name("q"));/* объявление переменной element класса WebElement в которую запишется конкретная нода или тэг, который мы нашли .*/
        searchField.sendKeys("Selenium");//вводим в поле поиска (найденный веб-элемент) слово Selenium
        searchField.sendKeys(Keys.ENTER);// имитируем нажатие клавиши ENTER
        List<WebElement> searchResultElements = driver.findElements(By.xpath("//div[@class='g']"));//создание списка, в который сладываем все результаты поиска
        System.out.println("Result  count: " + searchResultElements.size()); // подсчитываем количество найденных результатов

        //домашнее задание 08.02.2019
        String searchWord = "seleNIUM".toLowerCase();// задаю строковую переменную которой присваиваем значение искомого слова
        List<WebElement> linksList = driver.findElements(By.xpath("//cite[@class='iUh30']"));//out of score! создание списка ссылок на сайты с предварительным поиском ссылки
        ArrayList<String> linksArray = new ArrayList<String>();//out of score! создаю массив для последующего хранения ссылок на сайты
        int k = 5;// out of score! объявляю переменную, определяющую порядковый номер ссылки в массиве, на которую будет осуществлен переход после отработки цикла

        /* задаю цикл по списку результатов поиска searchResultElement*/
        for (int i = 0; i <= searchResultElements.size() - 1; i++) {
            String textElement = searchResultElements.get(i).getText(); /* задаю переменную, куда сохраняю текущий, полученный поиском, текст*/
            String linkElement = linksList.get(i).getText();//out of score! задаю переменную, куда сохраняю текущую, полученную поиском, ссылку
            System.out.println("Result №" + (i + 1) + ": " + textElement); /* вывожу пронумерованный результат поиска*/
            if (textElement.toLowerCase().contains(searchWord)) /* делаю проверку на наличие слова в строке и вывожу текст в зависимости от истинности выражения*/ {
                System.out.println("searchTerm found");
                linksArray.add(linkElement);// out of score! добавляю в массив ссылку на сайт, если выполняется условие
            } else {
                System.out.println("searchTerm not found");
            }
        }
        if (k > linksArray.size() || k <= 0) // out of score! сравниваем переменную с длиной массива найденых ссылок
        {
            driver.get(linksArray.get(0));// если в массиве нет столько ссылок, переходим на первую по порядку ссылку на сайт
        } else {
            driver.get(linksArray.get(k - 1)); // если есть - переходим на заданный переменной k порядковый номер ссылки на сайт
        }
        // --------------------=========== for each loop example
        //for each web element in searchResultElements print text
        /*for (WebElement searchResultElement : searchResultElements) {
            String searchResultElementText = searchResultElement.getText();
            System.out.println(searchResultElementText);
            if (searchResultElementText.contains("Selenium"))
        }{
            System.out.println("searchTerm Found");
        }
        else {
            System.out.println("searchTerm Not Found");
        }
        */
        /////////-------

    }
}