package librarypackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class LibraryMain extends JFrame implements LibraryFunctions {
	
	Map<String, LibraryStatus> map = new HashMap<>(); //this map contains registered books and their status
	Set<String> ReadBooks = new HashSet<>();  //this set contains books which are read and used as a second enum for same book
        LibraryMain()  {
			
			setTitle("My Library!!");
			setSize(500,500);
			setLayout(null);
			getContentPane().setBackground(new Color(70,130,180)); 
			int buttonWidth = 180;
			int buttonHeight = 40;
			int Xlocation = 160;
			JButton b1 = new JButton("Register");
			JButton b2 = new JButton("Registered Books");
			JButton b3 = new JButton("Borrow Book");
			JButton b4 = new JButton("Read Book");
			JButton b5 = new JButton("Return Book");
			b1.setBounds(Xlocation, 50, buttonWidth, buttonHeight);
			b2.setBounds(Xlocation, 110, buttonWidth, buttonHeight);
			b3.setBounds(Xlocation, 170, buttonWidth, buttonHeight);
			b4.setBounds(Xlocation, 230, buttonWidth, buttonHeight);
			b5.setBounds(Xlocation, 290, buttonWidth, buttonHeight);
			b1.setFocusPainted(false);
			b2.setFocusPainted(false);
			b3.setFocusPainted(false);
			b4.setFocusPainted(false);
			b5.setFocusPainted(false);
			add(b1);
			add(b2);
			add(b3);
			add(b4);
			add(b5);
			b1.addActionListener(e -> register());
			b2.addActionListener(e -> registeredbooks());
			b3.addActionListener(e -> borrow());
			b4.addActionListener(e -> read());
			b5.addActionListener(e -> returnbook());
			setVisible(true);
			
		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	              new LibraryMain();
		}
		
	    void register() {
	    	String name = JOptionPane.showInputDialog(this, "Please enter the book name");
	    	if (name == null || name.isEmpty()) {
	    		JOptionPane.showMessageDialog(this, "please enter a name!");
	    		return;
	    	}
	    	map.put(name, LibraryStatus.IN_LIBRARY);
	    	
	    
	    	
		}
	    
        void registeredbooks() {
    	String books = ("Registered Books List:\n");
    	books += "---------------------------\n";
    	
    	for (String i : map.keySet()) {
    		books += "book name : " + i + " book status : " + map.get(i);
    		if (ReadBooks.contains(i)) {
    		books += " + " + LibraryStatus.READ;
    		}
    		books += "\n";
    	}
    	JOptionPane.showMessageDialog(this, books);
    
        }
        void borrow() {
			String name = JOptionPane.showInputDialog(this, "Please enter the book name");
			if (map.containsKey(name)) {
			map.put(name, LibraryStatus.BORROWED);
			JOptionPane.showMessageDialog(this, name + " book is now borrowed");
			}
			else {
        		JOptionPane.showMessageDialog(this, "No such book!");
            }
		}
        
        void read() {
        	String name = JOptionPane.showInputDialog(this, "Please enter the book name you want to read");
        	if(!map.containsKey(name)) {
        	JOptionPane.showMessageDialog(this, "No such book!");
        	return;
        	}
        	ReadBooks.add(name);
        	JOptionPane.showMessageDialog(this, name + " book is read");
        	
        }
        void returnbook() {
        	
        	String name = JOptionPane.showInputDialog("which book you want to return?");
        	if (map.containsKey(name)) {
        		if (map.get(name)!=LibraryStatus.BORROWED) {
        		JOptionPane.showMessageDialog(this, "This book is not Borrowed!");
        		return;
        		}
        		map.put(name, LibraryStatus.IN_LIBRARY);
        		JOptionPane.showMessageDialog(this, name + " returned succesfully!");
        	}
        	else {
        		JOptionPane.showMessageDialog(this, "No such book!");
        		}
        	
        	
		}
    }

