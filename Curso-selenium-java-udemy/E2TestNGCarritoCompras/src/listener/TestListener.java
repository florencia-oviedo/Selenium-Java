package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TestListener implements ITestListener {
	
	String filePath = "C:\\Users\\Florencia Oviedo\\eclipse-workspace\\E2TestNGCarritoCompras\\test-output\\printScreenShot";

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//ITestListener.super.onTestFailure(result);
		System.out.println("*** Error" + result.getName() + " ha fallado ***");
		//fecha y hora
		String nombreMetodo = result.getName().toString().trim();
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("WebDriver");
		takeScreenShot(nombreMetodo,driver);
		
	}
	
	//funcion printstring
	public void takeScreenShot(String methodName, WebDriver driver) {
		Calendar calendario = Calendar.getInstance();
		SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd-mm-ss");
		String imprimirFecha = formatofecha.format(calendario.getTime());
		
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		//Con este metodo se guarda el archivo
		try {
			FileHandler.copy(sourceFile, new File(filePath+methodName+"-"+imprimirFecha+".png"));
			System.out.println("** Se hizo un print Screen en la carpeta "+filePath+" **");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
