package test.PageObjectModel.Pages;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;


public class RandomShitPage extends BasePage{




	public void findLinks(){
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		for (int i=0; i <links.size(); i++){
			System.out.println(links.get(i).getText());
		}



}

	}


		//		List<WebElement> rows=htmltable.findElements(By.tagName("tr"));
//		System.out.println("Number of rows:"+rows.size());
//		for(int rnum=0;rnum<rows.size();rnum++){
//			System.out.println(rows.get(rnum).getText());
//		{links.get(t).getText()
//		List<WebElement> columns=rows.get(rnum).findElements(By.tagName("th"));
//		System.out.println("Number of columns:"+columns.size());
//		for(int cnum=0;cnum<columns.size();cnum++)
//		{
//		System.out.println(columns.get(cnum).getText());
//		}
//		List<WebElement> links = rows.get(rnum).findElements(By.tagName("a"));
//		System.out.println("Number of a:"+links.size());
//		for (int t=0; t<links.size(); t++){
//			System.out.println(links.get(t).getText());
//
//		}

//		WebElement table = driver.findElement(By.cssSelector("#resource-content > div.table-responsive > table"));
//		List<WebElement> links = table.findElements(By.tagName("a"));
//		java.util.Iterator<WebElement> i = links.iterator();
//		while (i.hasNext()){
//			WebElement link = i.next();
//			System.out.println(link.getText());
//		}
//		for (WebElement e: links){
//		if(e.getTagName().equals("a")){
//
//		System.out.println(links.size());
//		for (int t=0; t<links.size(); t=t+1){
//		 System.out.println(links.get(t).getText());

//		}
//
//}
//}
//





