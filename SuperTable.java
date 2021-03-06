
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;

public class SuperTable{

   public static void main(String[] args) throws IOException {

      // Instantiate Configuration class
	   Configuration con = HBaseConfiguration.create();
	   
	   try (Connection connection = ConnectionFactory.createConnection(con); 
	           Admin admin = connection.getAdmin()) {
		// Instaniate HBaseAdmin class
		// Instantiate table descriptor class
		   HTableDescriptor tableDescriptor = new HTableDescriptor(TableName.valueOf("powers"));
		// Add column families to table descriptor
		   tableDescriptor.addFamily(new HColumnDescriptor("personal"));
	       tableDescriptor.addFamily(new HColumnDescriptor("professional"));        
	    // Execute the table through admin
	       admin.createTable(tableDescriptor);
	    
		   
	   }
      
	// Instantiating HTable class
	   try (Connection conn = ConnectionFactory.createConnection(con);
	           Table hTable = conn.getTable(TableName.valueOf("powers"))) {
		// Repeat these steps as many times as necessary	      
		   // Instantiating Put class
           // Hint: Accepts a row name

   	      // Add values using add() method
           // Hints: Accepts column family name, qualifier/row name ,value
		   
	          // Instantiating Put class
	          // accepts a row name.
	          Put p = new Put(Bytes.toBytes("row1"));

	          // adding values using add() method
	          // accepts column family name, qualifier/row name ,value
	          p.addColumn(Bytes.toBytes("personal"),
	          Bytes.toBytes("hero"),Bytes.toBytes("superman"));

	          p.addColumn(Bytes.toBytes("personal"),
	          Bytes.toBytes("power"),Bytes.toBytes("strength"));

	          p.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("name"),
	          Bytes.toBytes("clark"));

	          p.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("xp"),
	          Bytes.toBytes("100"));

	          // Saving the put Instance to the HTable.
	          hTable.put(p);
	          
	          
	          Put p1 = new Put(Bytes.toBytes("row2"));
	          p1.addColumn(Bytes.toBytes("personal"),
	          Bytes.toBytes("hero"),Bytes.toBytes("batman"));
	          p1.addColumn(Bytes.toBytes("personal"),
	          Bytes.toBytes("power"),Bytes.toBytes("money"));
	          p1.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("name"),
	          Bytes.toBytes("bruce"));
	          p1.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("xp"),
	          Bytes.toBytes("50"));
	          hTable.put(p1);
	          
	          Put p2 = new Put(Bytes.toBytes("row3"));
	          p2.addColumn(Bytes.toBytes("personal"),
	          Bytes.toBytes("hero"),Bytes.toBytes("wolverine"));
	          p2.addColumn(Bytes.toBytes("personal"),
	          Bytes.toBytes("power"),Bytes.toBytes("healing"));
	          p2.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("name"),
	          Bytes.toBytes("logan"));
	          p2.addColumn(Bytes.toBytes("professional"),Bytes.toBytes("xp"),
	          Bytes.toBytes("75"));
	          hTable.put(p2);
		   
	   }
	   try (Connection conn = ConnectionFactory.createConnection(con);
	           Table table = conn.getTable(TableName.valueOf("powers"))) {

		// Save the table
			
		      // Close table

		      // Instantiate the Scan class
	          Scan scan = new Scan();
	          // Scanning the required columns
	          scan.addColumn(Bytes.toBytes("personal"), Bytes.toBytes("hero"));

	          // Getting the scan result
	          try (ResultScanner scanner = table.getScanner(scan)) {

	              // Reading values from scan result
	              for (Result result = scanner.next(); result != null; result = scanner.next())

	              System.out.println(result);
	          }
	          }
      

      

      
     
      



      
     
      // Scan the required columns

      // Get the scan result

      // Read values from scan result
      // Print scan result
 
      // Close the scanner
   
      // Htable closer
   }
}

