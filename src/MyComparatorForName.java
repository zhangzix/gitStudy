import experiment.Book;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MyComparatorForName implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return Integer.parseInt(o1.getIsbn()) - Integer.parseInt(o2.getIsbn());
    }

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
