package librarypackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;



public class LibraryMain extends JFrame implements LibraryFunctions {
	int x = 1;
	Map<String, Integer> map = new HashMap<>();
	Map<String, LibraryStatus> map2 = new HashMap<>();			

        LibraryMain()  {
			
			setTitle("My Library!!");
			setSize(500,500);
			setLayout(new FlowLayout());
			JButton b1 = new JButton("Register");
			JButton b2 = new JButton("Registered Books");
			JButton b3 = new JButton("Borrow Book");
			JButton b4 = new JButton("Read Book");
			JButton b5 = new JButton("Return Book");
			b1.setSize(100, 100);
			b2.setSize(100, 100);
			b3.setSize(100, 100);
			b4.setSize(100, 100);
			b5.setSize(100, 100);
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
	    	map.put(name, x);
	    	x = x + 1;
	    	
		}
	    
        void registeredbooks() {
    	String books = ("Registered Books List:\n");
    	books += "---------------------------\n";
    	
    	for (String i : map.keySet()) {
    		books += "book name : " + i + " book code : " + map.get(i) + "\n";
    	}
    	JOptionPane.showMessageDialog(this, books);
    
        }
        void borrow() {
			String name = JOptionPane.showInputDialog(this, "Please enter the book name");
			if (map.containsKey(name)) {
				if (map2.containsKey(name)) {
					
				}
				
			}
		}
        
        void read() {
        	
        }
        void returnbook() {
			
		}
    }

