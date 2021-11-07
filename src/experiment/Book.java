package experiment;

import java.util.*;

/**
 * 实验6
 */
public class Book implements Comparable<Book> {
    private String isbn;
    private String title;
    private String author;

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "(" + isbn + "," + author + "," + title + ")\n";
    }

    @Override
    public int compareTo(Book o) {
        return Integer.parseInt(isbn) - Integer.parseInt(o.isbn);
    }
}

class BookTest {
    public static void main(String[] args) {
//        bookTest1();
//        bookTest2();
//        bookTest3();
        bookTest4();
    }

    public static void bookTest1() {
        System.out.println("LinkedList");
        List<Book> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Book("序号" + i, "标题" + i, "作者" + i));
        }
        System.out.println(list);
    }

    public static void bookTest2() {
        System.out.println("ArrayList");
        List<Book> list = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            list.add(new Book("序号" + i, "标题" + i, "作者" + i));
        }
        System.out.println(list);
    }

    public static void bookTest3() {
        System.out.println("HashSet");
        Set<Book> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(new Book("序号" + i, "标题" + i, "作者" + i));
        }
        System.out.println(set);
    }

    public static void bookTest4() {
        Map<Integer, Book> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i, new Book("序号" + i, "标题" + i, "作者" + i));
        }
        for (int i : map.keySet()) {
            System.out.print("key:" + i + ",value:" + map.get(i));
        }

    }
}

class BookTest2 {
    public static void main(String[] args) {
        Set<Book> set = new TreeSet<>();
        Book b1 = new Book("5", "标题5", "作者1");
        Book b2 = new Book("10", "标题3", "作者10");
        Book b3 = new Book("6", "标题4", "作者6");
        Book b4 = new Book("7", "标题2", "作者7");
        Book b5 = new Book("3", "标题10", "作者3");
        set.add(b1);
        set.add(b2);
        set.add(b3);
        set.add(b4);
        set.add(b5);
        Iterator<Book> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
    }
}
