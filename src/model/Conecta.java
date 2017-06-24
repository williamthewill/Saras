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
import org.openqa.selenium.support.ui.Select;

import view.TelaLogin;

public class Conecta {

	WebElement elemento;

	String link;
	WebDriver driver;
	String lotacao;
	WebElement frame;
	String lotacaoUsuario;

	public Conecta() {
	}

	public void conecta() throws IOException, InterruptedException {

		try {
			FirefoxProfile profile = new FirefoxProfile();
			profile.setPreference("network.proxy.type", 1); // tipo ante era 1
			profile.setPreference("network.proxy.http", "proxy.mp.sc.gov.br");
			profile.setPreference("network.proxy.http_port", 8080);
			profile.setPreference("network.proxy.ssl", "proxy.mp.sc.gov.br");
			profile.setPreference("network.proxy.ssl_port", 8080);

			String a = System.getProperty("user.dir");
			String b = "\\geckodriver" + this.validaSistemaOp() + ".exe";
			String c = a + b;

			System.setProperty("webdriver.gecko.driver", c);
			driver = new FirefoxDriver(profile);
			driver.get("http://suportesig.mp.sc.gov.br/sos/");

		} catch (WebDriverException e) {
			JOptionPane.showMessageDialog(null, "Não foi possível conectar, me feche e abra novamente");
		}
	}

	public void login(Atendente atendente, Chamado chamado) throws InterruptedException, IOException {
		this.frame = this.driver.findElement(By.cssSelector("frame"));
		this.driver.switchTo().frame(frame);
		this.driver.findElement(By.name("login")).sendKeys(atendente.getUsuarioRede());
		this.driver.findElement(By.name("senha")).sendKeys(atendente.getSenha());
		this.driver.findElement(By.name("mantis")).click(); // botsub1 = acessar
		
		if(!chamado.getESoftplan()){
		this.driver.findElement(By.className("botao1")).click();
		}
		
		Thread.sleep(2000);
	}

	public void clickCadastrarOcorrencias() {
		this.driver.findElement(By.linkText("Cadastrar ocorrências")).click();
	}

	public void clicKnomeSolicitante(Chamado chamado) throws InterruptedException {
		// coloca nome do usuarui no campo login
		this.driver.findElement(By.name("login")).sendKeys(chamado.getNomeSolicitante());
		this.driver.findElement(By.className("botao1")).click();
		Thread.sleep(1000);
		this.driver.findElement(By.linkText(chamado.getNomeSolicitante())).click();
	}

	public void clicLotacao() {
		Select seleciona = new Select(driver.findElement(By.name("lotacao")));
		seleciona.selectByIndex(1);// seleciono o primeiro indice,
		this.lotacaoUsuario = seleciona.getFirstSelectedOption().getText();
	}

	public String getLotacaoSolicitante() {
		return this.lotacaoUsuario;
	}

	public void clickContatoFeitoPor() {
		Select seleciona = new Select(driver.findElement(By.name("meio_contato")));
		seleciona.selectByIndex(2); // seleciono o indice,
	}

	public void clickTipoLocalChamado(Chamado chamado) {
		Select seleciona = new Select(driver.findElement(By.name("local_problema")));
		seleciona.selectByVisibleText(chamado.getLocalChamado());// seleciono o indice,															
	}

	public void clickDescricaoSolicitante(Chamado chamado) {
		this.driver.findElement(By.name("descricao")).sendKeys(chamado.getDescricaoSolicitante());
	}

	public void clickESof() {
		this.driver.findElement(By.name("salt")).click();
	}

	public void clicDescricaoProblema(Chamado chamado) {
		this.driver.findElement(By.name("resumo")).sendKeys(chamado.getDescricaoProblema());
	}

	public void clickTerminoCadastro() {
		this.driver.findElement(By.className("botao1")).click();// botao fim
	}

	public boolean loginAutentica(Atendente atendente) {
		boolean autentica = false;
		try {
			this.frame = this.driver.findElement(By.cssSelector("frame"));
			this.driver.switchTo().frame(frame);
			this.driver.findElement(By.name("login")).sendKeys(atendente.getUsuarioRede());
			this.driver.findElement(By.name("senha")).sendKeys(atendente.getSenha());
			this.driver.findElement(By.name("mantis")).click();
			// Thread.sleep(1000);
			this.driver.findElement(By.className("botao1")).click();

			Thread.sleep(2000);
			try {
				this.driver.findElement(By.linkText("Cadastrar ocorrências")).click();
				autentica = true;
			} catch (NoSuchElementException e) {
				this.driver.quit();
				autentica = false;
				JOptionPane.showMessageDialog(null, "Senha ou usuário inválido");
			}
		} catch (InterruptedException e) {

			autentica = false;
			JOptionPane.showMessageDialog(null, "Senha ou usuário inválido");
		}
		return autentica;
	}

	public boolean conectaAutentica(Atendente atendente) throws IOException, InterruptedException {
		boolean returner = false;
		try {

			FirefoxProfile profile = new FirefoxProfile();

			profile.setPreference("network.proxy.type", 1); // tipo ante era 1
			profile.setPreference("network.proxy.http", "proxy.mp.sc.gov.br");
			profile.setPreference("network.proxy.http_port", 8080);
			profile.setPreference("network.proxy.ssl", "proxy.mp.sc.gov.br");
			profile.setPreference("network.proxy.ssl_port", 8080);

			String a = System.getProperty("user.dir");
			String b = "\\geckodriver" + this.validaSistemaOp() + ".exe";
			String c = a + b;
			System.setProperty("webdriver.gecko.driver", c);

			driver = new FirefoxDriver(profile);
			minimizeFirefox();
			driver.get("http://suportesig.mp.sc.gov.br/sos/");

			returner = this.loginAutentica(atendente);

		} catch (WebDriverException e) {
			minimizeFirefox();
			JOptionPane.showMessageDialog(null, "Senha ou usuário inválido");
			this.driver.quit();
			return returner;

		}
		return returner;
	}

	public void minimizeFirefox() {
		try {
			Runtime.getRuntime().exec("wscript phantom/minimizaFirefox.vbs");
		} catch (IOException e) {
			System.out.println(e);
			System.exit(0);
		}

	}

	public void close() {
		this.driver.quit();
	}
	public String validaSistemaOp() throws IOException {
		String osCpu = System.getProperty("sun.arch.data.model"); // pega 32 /// 62												
		System.out.println(osCpu);
		return osCpu;
	}
}
