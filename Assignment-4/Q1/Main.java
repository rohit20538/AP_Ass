import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class input {
    public static int no_book;
    public static int no_rack;
}

class Temp {
    public static ArrayList<book> sort(ArrayList<book> list) {

        if (list.size() > 1) {
            list.sort((o1, o2) -> o1.T().compareTo(
                    o2.T()));

            return list;

        }
        return list;
    }

    public static ArrayList<book> ret(ArrayList<book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).T() == list.get(i + 1).T()) {
                if (list.get(i).I() > list.get(i + 1).I()) {
                    Collections.swap(list, i, i + 1);
                }
            }
        }
        return list;

    }

    public static ArrayList<book> ret2(ArrayList<book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).I() == list.get(i + 1).I()) {
                if (list.get(i).B() > list.get(i + 1).B()) {
                    Collections.swap(list, i, i + 1);
                }
            }
        }
        return list;

    }
}

class book {
    private static String Title;
    private static int barcode;
    private static int ISBN;

    public static String T() {
        return Title;
    }

    public static int B() {
        return barcode;
    }

    public static int I() {
        return ISBN;
    }

    public book(String Title, int barcode, int ISBN) {
        this.Title = Title;
        this.barcode = barcode;
        this.ISBN = ISBN;
        Data.add_book(this);
    }
}

class Data {

    private static ArrayList<book> book_list = new ArrayList<>();
    private static ArrayList<book> temp_list = new ArrayList<>();

    public static void add_book(book b) {

        book_list.add(b);
        if (book_list.size() > 1) {
            book_list = Temp.sort(book_list);
            book_list = Temp.ret(book_list);
            book_list = Temp.ret2(book_list);
        }
    }

    public static void div_slots() {
        int counter = 0;
        for (int i = 0; i < book_list.size(); i++) {
            temp_list.add(book_list.get(i));
            counter++;
            if (counter == (input.no_book / input.no_rack)) {
                counter = 0;
                slots.add_slot(temp_list);
                temp_list.clear();

            }
        }
    }

}

class slots {
    private static ArrayList<ArrayList<book>> slot = new ArrayList<>();

    public static void add_slot(ArrayList<book> D) {
        slot.add(D);
    }

    public static void displlay() {
        for (int i = 0; i < slot.size(); i++) {
            for (int j = 0; j < slot.get(i).size(); j++) {
                System.out.println("book name: " + slot.get(i).get(i).T() + "\n");
                System.out.println("book ISBN: " + slot.get(i).get(i).I() + "\n");
                System.out.println("book barcode: " + slot.get(i).get(i).B() + "\n");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String name;
        int Is;
        int br;
        System.out.println("Enter the no of books: ");
        input.no_book = s.nextInt();
        System.out.println("Enter the no of racks: ");
        input.no_rack = s.nextInt();
        for (int i = 0; i < input.no_book; i++) {
            System.out.println("Enter the title of book: ");
            name = s.next();
            System.out.println("Enter the barcode of book: ");
            br = s.nextInt();
            System.out.println("Enter the ISBN of book: ");
            Is = s.nextInt();
            book b = new book(name, br, Is);

        }
        Data.div_slots();
        slots.displlay();
    }

}