
import java.util.*;

public class Candidate {
	
	public class Prog_rep{
		int category;
		String code;
		Boolean PDstatus;
		public Prog_rep(String c, int cat, Boolean pd){ category=cat; code=c; PDstatus=pd; }
		public Prog_rep(){ code="-1"; }
	}
	
	private String ID;
	private Boolean PDstatus;
	private int category;
	private Boolean Nationality;
	private Boolean DSstatus;
	private ArrayList<Prog_rep> preference;
	private String waitlisted;
	private Prog_rep current;
	private Prog_rep next;
	
	public Candidate(String a, String pd, String categ){
		ID=a;
		if(pd.equals("Y")) PDstatus=true; else PDstatus=false;
		if(categ.equals("GE")) category=0;
		else if(categ.equals("OBC")) category=1;
		else if(categ.equals("SC")) category=2;
		else if(categ.equals("ST")) category=3;
		else if(categ.equals("F")) category=9;
		else if(categ.equals("DS")) category=8;
		if(category==9) Nationality=false; else Nationality=true;
		if(category==8) DSstatus=true; else DSstatus=false;
		preference = new ArrayList<Prog_rep>();
		waitlisted = "-1";
		current = new Prog_rep();
		next = new Prog_rep();
	}
	
	public void add_preference(int[] ranklist, String course){ 
		for(int i=0;i<4;i++){
			if(ranklist[i]!=0){ preference.add(new Prog_rep(course,i,false)); }
		}
		for(int i=4;i<8;i++){
			if(ranklist[i]!=0){ preference.add(new Prog_rep(course,i-4,true)); }
		}
	}
	
	public Prog_rep findnext(){ 
		int i = preference.indexOf(current);
		if(i+1<preference.size()) return preference.get(i+1);
		else return new Prog_rep();
	}
	
	public String retID(){ return ID; }
	public int retcategory(){ return category; }
	public Boolean retPDstatus(){ return PDstatus; }
	public Boolean retNationality(){ return Nationality; }
	public Boolean retDSstatus(){ return DSstatus; }
	public Prog_rep retcurrent(){ return current; }
	public Prog_rep retnext(){ return next; }
	public String retwaitlisted(){ return waitlisted; }
	public ArrayList<Prog_rep> retpreference(){ return preference; }
	public void setID(String a){ ID=a; }
	public void setcategory(int a){ category=a; }
	public void setPDstatus(Boolean a){ PDstatus=a; }
	public void setNationality(Boolean a){ Nationality=a; }
	public void setDSstatus(Boolean a){ DSstatus=a; }
	public void setcurrent(Prog_rep a){ current = a; }
	public void setnext(Prog_rep a){ next = a; }
	public void setwaitlisted(String a){ waitlisted = a; }
	public void setpreference(ArrayList<Prog_rep> a){ preference = a; }
	
}
