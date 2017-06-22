package model;

import java.io.IOException;

import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public class Conecta {
	
	WebElement elemento;

	String link;
	WebDriver driver;
	String lotacao;
	WebElement frame;
	String lotacaoUsuario;
	
	public Conecta(){}
	
	public void conecta() throws  IOException, InterruptedException{
		
	try{
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1); // tipo ante era 1
	    profile.setPreference("network.proxy.http", "proxy.mp.sc.gov.br");
	    profile.setPreference("network.proxy.http_port", 8080);
	    profile.setPreference("network.proxy.ssl", "proxy.mp.sc.gov.br");
	    profile.setPreference("network.proxy.ssl_port", 8080);
	  
		String a=System.getProperty("user.dir");
		String b="\\geckodriver"+this.validaSistemaOp()+".exe";
		String c= a+b;
		
		System.setProperty("webdriver.gecko.driver",c);
		driver = new FirefoxDriver(profile);
	    driver.get("http://suportesig.mp.sc.gov.br/sos/");
	   
	}catch (WebDriverException e){ 
		JOptionPane.showMessageDialog(null, "Não foi possível conectar, me feche e abra novamente");
	}
}


public String validaSistemaOp() throws  IOException{
	String osCpu=System.getProperty("sun.arch.data.model");  // pega 32 / 64
	
    System.out.println(osCpu);
    return osCpu;

  //String osName = System.getProperty("os.name"); pega sistem operacional
    //String osVersion= System.getProperty("os.version"); pega versao
 //String osCpu= System.getProperty("os.arch");  
 //System.out.println(System.getProperty("sun.arch.data.model"));
	
}

public void login() throws InterruptedException,IOException{
	//nomeDocampo // despois escreve
	/*Excel es = new Excel();
	
	this.frame= this.driver.findElement(By.cssSelector("frame"));
	this.driver.switchTo().frame(frame);
	this.driver.findElement(By.name("login")).sendKeys(Login.textField.getText());
	
	this.driver.findElement(By.name("senha")).sendKeys(es.getSenha());
	

	this.driver.findElement(By.name("mantis")).click();
	//botsub1 = acessar
	this.driver.findElement(By.className("botao1")).click();
	Thread.sleep(2000);*/
	

}
public boolean loginAutentica(Atendente atendente) {
	boolean autentica=false;  
	try {
	 this.frame= this.driver.findElement(By.cssSelector("frame"));
	  this.driver.switchTo().frame(frame);
	  this.driver.findElement(By.name("login")).sendKeys(atendente.getUsuario());
	  this.driver.findElement(By.name("senha")).sendKeys(atendente.getSenha());
	  this.driver.findElement(By.name("mantis")).click();
	  //Thread.sleep(1000);
	  this.driver.findElement(By.className("botao1")).click();
	
	  Thread.sleep(2000);
	  try{
	 this.driver.findElement(By.linkText("Cadastrar ocorrências")).click();
	  autentica=true;
	  }catch(  NoSuchElementException e){
		  this.driver.quit();
		  autentica=false;  
		  JOptionPane.showMessageDialog(null, "Senha ou usuário inválido");
	  }
	} catch (InterruptedException e) {
		
		 autentica=false;
		JOptionPane.showMessageDialog(null, "Senha ou usuário inválido");
	}
	return autentica;
}

public boolean conectaAutentica(Atendente atendente) throws IOException, InterruptedException{
	boolean returner = false;
	try{
		
	FirefoxProfile profile = new FirefoxProfile();
	
	profile.setPreference("network.proxy.type", 1); // tipo ante era 1
    profile.setPreference("network.proxy.http", "proxy.mp.sc.gov.br");
    profile.setPreference("network.proxy.http_port", 8080);
    profile.setPreference("network.proxy.ssl", "proxy.mp.sc.gov.br");
    profile.setPreference("network.proxy.ssl_port", 8080);
    
	String a=System.getProperty("user.dir");
	String b="\\geckodriver"+this.validaSistemaOp()+".exe";
	String c= a+b;
	System.setProperty("webdriver.gecko.driver",c);
	

	driver = new FirefoxDriver(profile);
	minimizeFirefox();
	driver.get("http://suportesig.mp.sc.gov.br/sos/");
	
	returner = this.loginAutentica(atendente);
	
}catch (WebDriverException  e){
	minimizeFirefox();
	JOptionPane.showMessageDialog(null, "Senha ou usuário inválido");
	this.driver.quit();
	return returner;
 
	}
	return returner;
}
public void minimizeFirefox(){
	try {
	      Runtime.getRuntime().exec( "wscript phantom/minimizaFirefox.vbs" );
	   }
	   	catch( IOException e ) {
	      System.out.println(e);
	      System.exit(0);
	   }
	
	}
public void close(){
	this.driver.quit();
}

}

