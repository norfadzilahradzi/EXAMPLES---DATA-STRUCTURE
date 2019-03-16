/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LENOVO
 */
public class BoundedGeneric {
    public static class Box<T> {
        private T t;          
        public void set(T t) {
            this.t = t;
        }
        public T get() {
            return t;
        }
        public <U extends Number> void inspect(U u){
            System.out.println("T: " + t.getClass().getName());
            System.out.println("U: " + u.getClass().getName());
        }
    }
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
        integerBox.set(new Integer(10));
        integerBox.inspect(2); 
      //  integerBox.inspect("some text"); // error: this is still String!
        System.out.println(integerBox.get());        
        Box<String> stringBox = new Box<>();
        stringBox.set("ABC");
      //  stringBox.inspect("some text"); // error: this is still String!
        stringBox.inspect(5); 
        System.out.println(stringBox.get());
    }
}
