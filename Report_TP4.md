# TP4 java - Amirhossein Pouyanfar - Group 2 Mr. Rémy Forax

### Exercise 1

6. Écrire une classe Main qui affiche Hello Eclipse.

**Answer** : Here's a `Main` class, printing "Hello Eclipse" :
```java
public class Main {
  public static void main(String[] args) {
    System.out.println("Hello Eclipse");
  }
}
```

7. A faire à la maison pour le compte rendu:

(1) Que fait sysout + Ctrl + Space dans un main ?
(2) Que fait toStr + Ctrl + Space dans une classe ?
(3) Définir un champs foo de type int, que fait get + Ctrl + Space, et set + Ctrl + Space .
(4) Dans le menu Source, comment générer un constructeur initialisant le champ foo ?
(5) Sélectionner le nom de la classe puis Alt + Shift + R, qu'obtient-on ? Même question avec le champ foo .
(6) Écrire a = 2 + 3 + 4, puis sélectionner 2 + 3 puis Alt + Shift + L .
(7) Écrire new Integer(2), en gardant le curseur après `)`, appuyer sur Ctrl + Shift + 1, que se passe-t-il ?
(8) Déclarer une variable s de type String et cliquer sur String en maintenant la touche Ctrl . Que se passe-t-il ?
(9) Dans la méthode toString(), que fait un Ctrl + Clic sur super.toString() ?
(10) Sélectionner le champs foo, puis Ctrl + Shift + G. Que se passe-t-il ?
(11) À quoi sert Ctrl + Shift + O ?
(12) À quoi sert Ctrl + Shift + C ?


**Answer** : Here are the answers to Exercise 7:
1. In eclipse, if you type `sysout` in a `main` and press `Ctrl + Space`, eclipse
	will automatically expand it to `System.out.println();`
2. Using eclipse, if you type `toStr` in a main and then press `Ctrl + Space`, eclipse
	will automatically generate you a `toString()` method for the class.
3. If you define a field named `Foo` of type `int`, then type `get` and press `Ctrl + Space`,
	eclipse will generate you a gette method for the field like this:
	```java
	public int getFoo() {
	  return foo;
	}
	```
	if you type `set` and then press `Ctrl + Space`, eclipse will generate you a setter method like this:
	```java
	public void setFoo(int foo) {
	  this.foo = foo;
	}
	```
4. Go to the `Source` menu and click on `Generate Constructor using Fields...`. A dialog box will appear,
displaying a list of available fields in that class. Make sure that the field `foo` is selected in the list.
Finally click on the OK button.
5. When you select a class name and maintain `Alt + Shift + R`, you are triggering "Rename" refactoring feature.
this allows you to quickly rename the selected class (or field) throughout your codebase without manually scrolling,
searching and renaming each occurence.
6. This allows you to extract the selected expression into a new separate local variable.
7. This triggers the `Quick Fix` feature. You can then toggle through various potential quick fixes 
or improvements to your code based on the context.
8. Ctrl-clicking in eclipse is a navigation feature. It allows you to quickly navigate to the declaration or
definition of a variable or type. However, in this case we are Ctrl-clicking on a core Java type like String,
in our code, there is no declaration for String !
9. That would take you to the source code of the `toString()` method of the superclass from which the class you're working on is 
extending.
10. It will trigger the `References in Workspace` feature, that allows you to search for and view all the references to the
selected field throughout your workspace, including all the packages. It will open a Search tab showing these references.
11. When you press `Ctrl + Shift + O`, eclipse will automatically add, remove , and organize the import statements 
in your java source code files. By doing this, you will make sure that you have the correct and necessary import statements.
12. It's used to toggle the comment status of the selected code blocks or lines. If these blocks or lines are already commented,
it will uncomment them.

### Exercise 2

1. Dans le package fr.uge.library, écrire une classe Library avec un champs books de type ArrayList ainsi qu'un constructeur sans paramètre initialisant le champ books.
Attention à déclarer les bons modificateurs pour le champ books.
Note : il est possible que le compilateur lève un warning, si c'est le cas, comment corriger le problème ? 
2. Ajouter une méthode add qui permet d'ajouter des books (non null) à la liste de livres.
3. Écrire une méthode findByTitle qui permet de trouver un livre en fonction de son titre dans la bibliothèque. La méthode doit renvoyer null dans le cas où aucun livre n'a le bon titre. 

**Answers** : Here is a `Library` class, having a field `books` of type `ArrayList`, with a constructor initializing this
field. In addition to that, we have added an `add` method, which will be used to add new book to our library. Finally, we 
have defined a `findByTitle` method which allows us to find a book by its title.
```java
package fr.uge.library;

import java.util.ArrayList;
import java.util.Objects;

public class Library {
  private final ArrayList<Book> books;
	
  public Library () {
    books = new ArrayList<Book>();
  }
	
  public void add(Book b) {
    Objects.requireNonNull(b);
    this.books.add(b);
  }
	
  public Book findByTitle(String title) {
    for(var book : books) {
      if(book.title().equals(title)) {
        return book;
      }	 
    }
    return null;
  }
	
  @Override
  public String toString() {
    var res = new StringBuilder();
    var separator = "";
    for(var book : books) {
      res.append(separator).append(book);
      separator = ", ";
    }
  return res.toString();
  }
	
  public static void main(String[] args) {
    var library = new Library();
    Book book1 = new Book("Da Vinci Code", "Dan Brown");
    Book book2 = new Book("Harry Potter and the Order of the Phoenix", "J.K Rowling");
    Book book3 = new Book("Grapes of Wrath", "John Steinbeck");
    library.add(book1);
    library.add(book2);
    library.add(book3);
    System.out.println(library.findByTitle("Da Vinci Code"));
    System.out.println(library);
  }
}

```

4. Comment le compilateur compile-t-il une boucle foreach sur une collection ?
Utiliser la commande javap pour vérifier !
```bash
    javap -c Library.class
```     

**Answer** : The `for-each` loop is transformed into a `while` on an `Iterator` object by the compilator.
This fact is deduces, by observing this line in the bytecode :
```bash
4: invokevirtual #26                 // Method java/util/ArrayList.iterator:()Ljava/util/Iterator;
9: invokeinterface #30,  1           // InterfaceMethod java/util/Iterator.hasNext:()Z
18: invokeinterface #36,  1           // InterfaceMethod java/util/Iterator.next:()Ljava/lang/Object;
```

5. Expliquer pourquoi la méthode findByTitle doit renvoier null plutôt que de lever une exception.  

**Answer** : In Java, we prefer to have two types of methods : 
First, those who modify something, have `void` as their return value.
Second, those who calculate, or achieve something, which they return,
thus their return value type would be that.

6. Écrire une méthode toString affichant les livres de la bibliothèque dans l'ordre d'insertion, avec les livres séparés par une virgule (avec un espace après la virgule).  

**Answer** : Here's a `toString()` method, printing a library's books, separated by commas (`", "`):
```java
public String toString() {
  var res = new StringBuilder();
  var separator = "";
  for(var book : books) {
    res.append(separator).append(book);
    separator = ", ";
  }
  return res.toString();
}
```

### Exercise 3

1. The `findByTitle` method that we defined in the `Library` class, has a complexity of `O(n)`, it 
loops through the book ArrayList, passing once through each book.
2. java.util.HashMap is the implementation of the Hash Table, permitting null values and null keys
(as opposed to Hashtable), 
