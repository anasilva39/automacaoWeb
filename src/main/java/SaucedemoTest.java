import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class SaucedemoTest {
    public static void main(String[] args) {
        // Configurar o caminho para o WebDriver do Chrome
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        // Inicializar o WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Abrir o site
            driver.get("https://www.saucedemo.com/");

            // Login
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Selecionar produtos e adicionar ao carrinho
            WebElement firstProduct = driver.findElements(By.cssSelector(".inventory_item")).get(0);
            firstProduct.findElement(By.cssSelector(".btn_inventory")).click();  // Adiciona o primeiro produto

            // Ir para o carrinho
            driver.findElement(By.id("shopping_cart_container")).click();

            // Checkout
            driver.findElement(By.id("checkout")).click();

            // Preencher os campos de checkout
            driver.findElement(By.id("first-name")).sendKeys("Ana");
            driver.findElement(By.id("last-name")).sendKeys("Silva");
            driver.findElement(By.id("postal-code")).sendKeys("12345");
            driver.findElement(By.id("continue")).click();

            // Finalizar compra
            driver.findElement(By.id("finish")).click();

            // Verificar mensagem de confirmação
            String confirmationMessage = driver.findElement(By.cssSelector(".complete-header")).getText();
            System.out.println("Mensagem de confirmação: " + confirmationMessage);

            // Voltar ao inventário
            driver.findElement(By.id("back-to-products")).click();
        } finally {
            // Fechar o navegador
            driver.quit();
        }
    }

}
