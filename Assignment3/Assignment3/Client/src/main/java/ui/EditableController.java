package ui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import entity.Article;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import mapper.Mapper;

public class EditableController implements Observer {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label relatedArticlesLB1;

    @FXML
    private Label relatedArticlesLB2;

    @FXML
    private TextField authorTF;

    @FXML
    private TextField titleTF;

    @FXML
    private TextArea abstractTF;

    @FXML
    private TextArea bodyTF;

    @FXML
    private TextField relatedTF;

    @FXML
    private TextField relatedTF1;

    @FXML
    private TextField relatedTF2;

    @FXML
    private Button doneBTN;
    
    Client client = Client.getInstance();
    Main main = new Main();
    
    @FXML
    void edit(ActionEvent event) throws IOException, ClassNotFoundException
    {
    	Article a = Client.getInstance().getArticle();
    	
    	
    	String ans = (String) client.getIn().readObject();
    	String originalJsonArticle = Mapper.articleToJson(a);
    	
    	
    	
    	
    	a.setAuthor(authorTF.getText());
    	a.setAbs(abstractTF.getText());
    	a.setBody(bodyTF.getText());
    	a.setTitle(titleTF.getText());
    	
    	List<Article> list = new ArrayList<Article>();
    	
    	if (!relatedTF.getText().equals(""))
    	{
    		client.getOut().writeObject("article" + " " + relatedTF.getText());
			client.getOut().flush();
			
			String answer = (String) client.getIn().readObject();
			if (!answer.equals("error"))
			{
				Article article = Mapper.articleFromJson(answer);
				list.add(article);
			}
    	}
    	
    	if (!relatedTF1.getText().equals(""))
    	{
    		client.getOut().writeObject("article" + " " + relatedTF1.getText());
			client.getOut().flush();
			
			String answer = (String) client.getIn().readObject();
			if (!answer.equals("error"))
			{
				Article article = Mapper.articleFromJson(answer);
				list.add(article);
			}
    	}
    	
    	if (!relatedTF2.getText().equals(""))
    	{
    		client.getOut().writeObject("article" + " " + relatedTF2.getText());
			client.getOut().flush();
			
			String answer = (String) client.getIn().readObject();
			if (!answer.equals("error"))
			{
				Article article = Mapper.articleFromJson(answer);
				list.add(article);
			}
    	}
    	
    	a.setRelatedArticles(list);
    	
    	String jsonArticle = Mapper.articleToJson(a);
    	
    	if (ans.equals("create")){
    		client.getOut().writeObject("created" + " " + jsonArticle);
    		client.getOut().flush();
    		
    		String answer = (String) client.getIn().readObject();
    		if (answer.equals("error"))
    			Alerts.display("error", "Error", "Article with the same name exists.");
    		else
    			Alerts.display("info", "Creation", "Article successfully created.");
    	}
    	else if (ans.equals("update")){
    		client.getOut().writeObject("updated" + " " + originalJsonArticle + " " + jsonArticle);
    		client.getOut().flush();
    		
    		String answer = (String) client.getIn().readObject();
    		if (answer.equals("error"))
    			Alerts.display("error", "Error", "Article with the same name exists.");
    		else
    			Alerts.display("info", "Update", "Article successfully updated");
    	}
    	
    	main.changeScene("writerview.fxml");
    }

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}

	@FXML
	public void exitApplication(ActionEvent event) {
	   Platform.exit();
	}
}
