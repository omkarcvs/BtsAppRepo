package com.app.bts.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * This is a class which contains all common utility.
 * 
 * @author Omkar Singh
 * @created 11.03.2022
 */
public class CommonUtils {
	/**
	 * Do the copy/clone, the values being copied by value.
	 * 
	 * @param orig
	 * @return
	 */
	public static Object deepCopy(Object orig) {
		return copy(orig);
    }
	
	/**
	 * Do a deep clone of an object take from.
	 * 
	 * @param orig
	 *            original object.
	 * @return new object copied.
	 * @throws ServiceException
	 *             if service exception occurs.
	 */
    public static Object copy(Object orig){
        Object obj = null;

        try {
            // Write the object out to a byte array
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bos);
            out.writeObject(orig);
            out.flush();
            out.close();

            // Make an input stream from the byte array and read
            // a copy of the object back in.
            ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(
                        bos.toByteArray()));
            obj = in.readObject();
        } catch (IOException e) {
            
           e.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
          
            cnfe.printStackTrace();
        }

        return obj;
    }
    
    public static String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        t.printStackTrace(new PrintWriter(sw));
        return sw.toString();
    }
    
}
