package com.ycx.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.SpellCheckResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.ModifiableSolrParams;

public class SolrTest {
	public void add() throws SolrServerException, IOException{
	   /* String url = "http://localhost:8087/solr/core1";  
	    HttpSolrClient server = new HttpSolrClient(url);
	    for(int i=0;i<100;++i) {
	        SolrInputDocument doc = new SolrInputDocument();
	        doc.addField("id", "book-" + i);
	        doc.addField("name", "The Legend " + i);
	        server.add(doc);
	        if(i%100==0) server.commit();  // periodically flush
	      }
	    System.out.println("add");
	      server.commit();
	      M2_HOME=/Users/apple/Downloads/apache-maven-3.3.9
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_79.jdk/Contents/Home/bin
PATH=$JAVA_HOME/bin:$PATH:$M2_HOME/bin
CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar


*/
	}
	public void test(){
		 String url= "http://42.62.97.87:8983/solr/outline";
	    //String url = "http://localhost:8087/solr/core1";  
	    HttpSolrClient server = new HttpSolrClient(url);
	    /*
	    SolrQuery query = new SolrQuery();
	    query.setFields("name");
	    query.setStart(0);    
	    query.set("defType", "edismax");
	    System.out.println("test");
	    QueryResponse response = solr.query(query);
	    System.out.println(response);
	    SolrDocumentList results = response.getResults();
	    for (int i = 0; i < results.size(); ++i) {
	      System.out.println(results.get(i));
	    }
	*/
		ModifiableSolrParams params = new ModifiableSolrParams();
		params.set("q", "*:*"); // q表示查询字符串
		String name = "建筑工程施工技术";
		SolrQuery filterQuery = new SolrQuery(); 
		filterQuery.addFilterQuery("name:" + (name==null||name.equals("")? "*":"\""+name+"\"")); //.add("name",(name==null||name.equals("")? "*":name));
		params.add(filterQuery);
		System.out.println(filterQuery);
		params.set("start",0); 
		  //start是开始记录数 分页用
		 params.set("rows",100); 
		 System.out.println(params);
		try {
			QueryResponse 	queryResponse = server.query(params);
			SolrDocumentList results = queryResponse.getResults();
			SpellCheckResponse res = queryResponse.getSpellCheckResponse();
			for(int i=0;i<results.size();i++){
				
					System.out.println(results.get(i));
				}
		} catch (SolrServerException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
			
		/*List<Map<String, Object>> list = orderBiz.findAllVideoOrderList(parameters.getConditions().getItems(), null,
				null, false);*/

	
	
	}
}
