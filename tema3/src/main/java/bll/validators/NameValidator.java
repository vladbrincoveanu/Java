package bll.validators;

import java.lang.reflect.InvocationTargetException;

public class NameValidator implements Validator<Object>{

	/**
	 *verifica daca fieldul nume din tabela data de un obiect este null
	 */
	public void validate(Object t){
		try {
			try {
				String a = String.valueOf(t.getClass().getDeclaredMethod("getName").invoke(t));
				if(a.equals("")){
					throw new IllegalArgumentException("Introducere nume");
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
