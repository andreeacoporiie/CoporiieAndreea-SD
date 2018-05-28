package ui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import entity.Article;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import mapper.Mapper;

public class ArticleController implements Initializable, Observer {

    @FXML
    private AnchorPane anchor;

    @FXML
    private Label titleLB;

    @FXML
    private Label bodyLB;

    @FXML
    private Button backBTN;

    @FXML
    private Label abstractLB;

    @FXML
    private Label someLB;

    @FXML
    private Label authorLB;
    
    @FXML
    private Label relatedArticlesLB;

    @FXML
    private Label relatedArticlesLB1;

    @FXML
    private Label relatedArticlesLB2;

    
    Main main = new Main();
    Client client = Client.getInstance();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Article a = client.getArticle();
		titleLB.setText(a.getTitle());
		abstractLB.setText(a.getAbs());
		authorLB.setText(a.getAuthor());
		bodyLB.setText(a.getBody());
		
		List<Article> art = new ArrayList<Article>();
		art = a.getRelatedArticles();
		try{
			relatedArticlesLB.setText(art.get(0).titleToString());
			relatedArticlesLB.setText(art.get(1).titleToString());
			relatedArticlesLB.setText(art.get(2).titleToString());
		} catch (Exception e)
		{
			
		}
		
	}
	
    @FXML
    void goBack(ActionEvent event) throws IOException {
    	if (client.getAdminUser() == 2)
    		main.changeScene("generalview.fxml");
    	else if (client.getAdminUser() == 1)
    		main.changeScene("adminview.fxml");
    	else
    		main.changeScene("writerview.fxml");
    }
   
	
	 @FXML
	 void relatedArt(MouseEvent event) throws ClassNotFoundException, IOException {
		 clickRelated(relatedArticlesLB);
	 }

	 @FXML
	 void relatedArt1(MouseEvent event) throws IOException, ClassNotFoundException {
		 clickRelated(relatedArticlesLB1);
	 }

	 @FXML
	 void relatedArt2(MouseEvent event) throws IOException, ClassNotFoundException {
		 clickRelated(relatedArticlesLB2);
	 }
	 
	 void clickRelated(Label l) throws IOException, ClassNotFoundException{
		 if (!l.getText().equals("<None>") && !l.getText().equals(""))
		 {
			String title = relatedArticlesLB.getText();
			client.getOut().writeObject("article" + " " + title);
			client.getOut().flush();
			System.out.println("Sent request article");
			 
			String answer = (String) client.getIn().readObject();
			Article article = Mapper.articleFromJson(answer);
			 
			client.setArticle(article);
			main.changeScene("articleview.fxml");
		 }
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
