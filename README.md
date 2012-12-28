#Software Design Pattern for Creating Webdriver/Selenium PageObjects using Enum Pattern


##Problem Definition
Today Webdriver is a most successful tool for browser automation. Webdriver has bindings
for multiple programming languages such as JAVA, PERL, and PHP etc. If we use any of
these language to build automation, then we should implement some kind of page object
designs for defining our web pages as an objects. Today there are few page object design patterns
in use, the traditional one, which models a webpage as a Class, elements as properties and
web actions as methods. This design exists from the beginning of
the Webdriver era and it still servers a lot of folks. Approximately 80% of the 
Webdriver community uses the same approach for their page objects. Loadable component
is another implementation designed to solve this problem in a different way,
it shares a lot of ideas from the traditional one, you can read more on that 
here http://code.google.com/p/selenium/wiki/LoadableComponent Ok let's look at the problems,
using these patterns creates a lot of duplicate code, too many methods, too many locator definitions,
hard to read.

##A New Solution
Page Objects using Enum approach is a new idea. A new design and model for solving the same problem.
This design is not limited to Java Enum. This idea can be implemented on any Webdriver binding
that supports Enum pattern. In Enum Page Object model we create Classes for webpages,
but instead of creating properties for web elements, we create Enum to group similar
web element types to reduce code and reuse methods. If we take an example, in a
web page the Links, Buttons, Labels, Textbox, Dropdown are web element type. These types 
can be grouped as an Enum, each Enum can have a list of same element type, we can
write methods inside these Enum for our web actions. Java Enum is very close to a
Class with few limitations, you can create static instance called Enum items, which 
can accept parameters to construct the object, later your can, access these in a static
way and call the methods.

In our design we pass html ID, Class Name and @Xpath as an input to define the location
of each elements, in action these values will be used by the Enum methods to perform Webdriver
actions on Browser DOM, actions such as click, type, select etc.


##Enum page object design in pseudo code

```java
enum <enum name>
  /* Object */
  enum_item_link1(html_locator_type, html_locator),
  enum_item_link2(html_locator_type, html_locator),
  enum_item_link3(html_locator_type, html_locator)

  /* Member variable */
  member_locator_type,
  member_locator
  
  /* Methods */
  methods_click()
    webdriver_click(member_locator_type, member_locator)
  
  methods_get_text()
     webdriver_get_text(member_locator_type, member_locator)
```

##Enum page object design in Java
```java
public class HomePage {
 public static enum Link {
  HOME(By.id, "home-link-id"),
  PRIVACY(By.name, "privacy-link-id"),
  CONTACT_US(By.class, "contact-us-link-id"),
  TERMS(By.xpath, "\\div[text() = '/terms']");
  
  public By by;
  public String locator;
  
  public click(driver) {
   driver.findElement(by, locator).click();
  }
  
  public getLinkText(driver) {
   driver.findElement(by, locator).getText();
  }
 }
}

```
##License
(The MIT License)

Copyright (c) 2011-2012 Venkatesan Sundramurthy <venkatesan.sundramurthy@gmail.com>

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the 'Software'), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED 'AS IS', WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
