package demoblaze;

public class localizadores{
	
	//Registro de usuario
	 public String registro (String tipo) {
	        
		 if (tipo == "sign_in")          {return  "signin2"; }
		 else if (tipo == "sign_user" )  {return  "sign-username";}
		 else if (tipo == "sign_pass")   {return  "sign-password";}
	     else if (tipo == "sign_btn")    {return  "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]";}
	     else                            {return "no encontrado";}
		 
	 }	
	 
	 // Ingreso de usuario
	 public String ingreso (String tipo) {
	        
		 if      (tipo == "login")       {return  "login2"; }
		 else if (tipo == "ing_usu" )    {return  "//*[@id=\"loginusername\"]";}
		 else if (tipo == "ing_pass")    {return   "//*[@id=\"loginpassword\"]";}
	     else if (tipo == "ing_btn")     {return  "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]";}
	     else if (tipo == "log_out")     {return  "//*[@id=\"logout2\"]";}
	     else                            {return "no encontrado";}
		 
	 }	
	 
	 //Mensajes
	 public String mensaje (String tipo) {
	        
		 if (tipo == "sign_msj")    {return  "//*[text()='Sign up successful.']";}
	     else if (tipo == "sign_msj1")   {return  "Sign up successful.";}
	     else if (tipo == "sign_msj2")   {return  "//*[text()='This user already exist.']";}
	     else if (tipo == "sign_msj3")   {return  "This user already exist.";}
	     else if (tipo == "sign_msj4")   {return  "//*[text()='Wrong password.']";}
	     else if (tipo == "sign_msj5")   {return  "Wrong password.";}
	     else if (tipo == "sign_msj6")   {return  "//*[text()='Product added.']";}
	     else if (tipo == "sign_msj7")   {return  "//*[text()='Thank you for your purchase!']";}
	     else                            {return "no encontrado";}
		 
	 }	
	 
	 public String carrito (String tipo) {
	        
		 if (tipo == "cart")             {return  "Cart";}
	     else                            {return "no encontrado";}
		 
	 }	
	 
}
	


