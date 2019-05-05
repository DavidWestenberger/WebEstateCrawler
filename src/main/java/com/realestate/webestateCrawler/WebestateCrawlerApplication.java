package com.realestate.webestateCrawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebestateCrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebestateCrawlerApplication.class, args);

		final String collinCountyForclosureListURL = "https://apps.collincountytx.gov/ForeclosureNotices";

		try{

			final Document forclosureDocument = Jsoup.connect(collinCountyForclosureListURL).get();

			System.out.println(forclosureDocument.outerHtml());

			//loop through the sale date and grab all the hrefs
			System.out.println("INSIDE FOR LOOP:");
			for(Element row : forclosureDocument.select("div.col-xs-12.filterSection div")){
				if( row.select("div.filterTitle").text().equals("Sale Date")){
					//Element temp = row.select("row:nth-of-type(2");
					continue;
				}
				else{
					String insideLinkText = row.select("a").text();
					System.out.println(insideLinkText);
					
				}

				//System.out.println(row);

			}
		}
		catch( IOException exception) {
			exception.printStackTrace();
		}

	}
}
