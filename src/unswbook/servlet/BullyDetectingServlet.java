package unswbook.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import unswbook.beans.Post;
import unswbook.dao.PostDao;
import unswbook.methods.CheckSameWords;

/**
 * Servlet implementation class BullyReport
 */
@WebServlet("/BullyDetecting")
public class BullyDetectingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BullyDetectingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PostDao pd = new PostDao();
		ArrayList<Post> posts = new ArrayList<Post>();
		ArrayList<Post> bullyPosts = new ArrayList<Post>();
		try {
			posts = pd.getAllPosts();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bullyAWords = "Abuse " + "Abusive " + "Acknowledge " + "Acting out " +  "Actual " + "Addictive " + "Administration " + "Adult " + "Advocate "  + "Affect "  + "Afraid " + "Aggravate " + "Aggressive " + "Alone " + "Ambush " + "Annoy "  + "Anonymous " + "Antagonistic " + "Antagonize " + "Anxiety " +  "Apathetic " + "Appropriate " + "Arrogant " + "Assault " + "Attack " +  "Attentive "+ " Attitude " +  "Audience " + "Authority ";
		String bullyBWords = "Beat up " + "Behavior " + "Belittle " + "Bias " + "Blase " + "Blindside " + "Boorish "+  "Bother " + "Braggart " + "Bully " + "Burden "  + "Bystander ";
		String bullyCWords = "Callow " + "Campus " + "Capitulate " + "Captious " +  "Case " + "Cautious " +  "Challenge " + "Charges " + "Cheat " + "Childhood " + "Churlish " + "Coaches " + "Cold " +  "Communication "  + "Complain " + "Complaint " + "Compulsive " + "Concern " + "Confidence " + "Conflict " + "Consequence " + "Console " + "Consult " + "Contemptible " +  "Control " + "Corner " + "Counselor " + "Courage "+ "Covetous " +  "Creepy " + "Crime " + "Criminal " + "Critical " + "Crude " + "Cruel " + "Crying " + "Culpable " + "Curt " + "Cyber-bullying " + "Cynical ";
		String bullyDWords = "Decency " +  "Deed " + "Demeaning " + "Dependent " + "Depression " + "Desensitize " + "Despair "  + "Despot " + "Destructive " + "Devastate " + "Devious " + "Dictatorial " + "Die " + "Different " + "Disaster " + "Discourage " + "Discussion " + "Disdainful " + "Dishonesty " + "Dishonorable " + "Disregard " + "Disrespectful " + "Dodge " + "Dominate ";
		String bullyEWords = "Effect " + "Effort " + "Egoist " + "Egotism " + "Elitist " + "Elude " + "Embarrassment " + "Emotional " + "Empathy " + "Endure " + "Epithet " + "Escalation " + "Evade " + "Evil " + "Exclusion " +  "Explosive " +  "Exposure " + "Expulsion " + "Extort " + "Extravagant " + "Extreme "+ "Extreme ";
		String bullyFWords = "Failure " + "Falseness " + "Fanatic " + "Favoritism " + "Fea r" + "Fervid " + "Flashback "  + "Focus " + "Football " + "Force " + "Frailty " + "Friendship " + "Fright " + "Frightened " + "Frozen ";
		String bullyGWords = "Gang " + "Glib " + "Gossip " + "Grouchy " + "Guilty ";
		String bullyHWords = "Harassment " + "Hard-hearted " + "Haunted " + "Hazing "  + "Head-off " + "Healing " + "Heedless " + "Help " + "Hidden " + "Hide " + "Hopeless " + "Hostile " + "Hounded " + "Hurt ";
		String bullyIWords = "Ignoble " + "Ignorant " + "Ignor " + "Ill-tempered " + "Impetuous "  + "Implacable " + "Impolite " + "Improper " + "Imprudent " + "Impudent " + "Impunity " + "Inappropriate " + "Incidence " + "Indecent " + "Indecorous " + "Indifference " + "Ineffective " + "Innocent " + "Insight " + "Insolent " + "Insulting " + "Intentional " + "Intolerant " + "Irascible " + "Irresponsible " + "Isolated ";
		String bullyJWords = "Jaundiced " + "Jealousy " + "Judge " + "Jumpy " + "Justice "  + "Justify " + "Juvenile ";
		String bullyKWords = "Keen " + "Kicked " + "Kindness " + "Knockdown " + "Knowledge " + "Knuckle ";
		String bullyLWords = "Language " + "Lethal " + "Lifelong " + "Litigation " + "Loathsome " + "Loss ";
		String bullyMWords = "Malevolent " + "Malicious " + "Manipulative " + "Marked "  + "Mean "  + "Meddler " + "Medical " + "Memories " + "Merciless " + "Mercurial " + "Mercy " + "Misbehavior " + "Miserable " + "Misery " + "Mistrustful " + "Momentum " + "Monitor ";
		String bullyNWords = "Nefarious " + "Neglectful " + "Negligent " + "Nervous " + "Neurotic " + "Notorious " + "Nuisance ";
		String bullyOWords = "Obnoxious " + "Obsequious " + "Odious " + "Offensive " + "Oppressive " + "Ostracize " + "Out-of-line " + "Outcast " + "Outrageous " + "Overwhelm ";
		String bullyPWords = "Pain " + "Painful " + "Partial " + "Passive " + "Peace "  + "Peers " + "Pervasive " + "Petulant "  + "Physical " + "Picked on " + "Pity " + "Police " + "Popularity " + "Prejudicial " + "Preposterous " + "Pretentious " + "Prevention " + "Prey on " + "Problem " + "Proceed " + "Protection " + "Protest " + "Psychological " + "Punched " + "Punishment " + "Pushing " + "Put-down ";
		String bullyQWords = "Quake " + "Quandary " + "Quarrelsome " + "Querulous " + "Quibbler " + "Quirky " + "Quiver ";
		String bullyRWords = "Rancorous " + "Reckless " + "Report " + "Representation " + "Repugnance " + "Reticent " + "Rights " + "Rude "  + "Ruthless ";
		String bullySWords = "School " + "School " + "Scornful " + "Secrets " + "Seek " +  "Selfish " + "Sensitive " + "Seriousness " + "Shake " + "Shame " + "Shock " + "Shouting " + "Shoving " + "Shunned " + "Silence " + "Skill " + "Slur " + "Socialize " + "Solution " + "Sour " + "Spit on " + "Sports " + "Stern " + "Struggle " + "Suffering " + "Suicidal " + "Sullen " + "Support " + "Surly " + "Survivor " + "Suspect " + "Suspension " + "Suspicious ";
		String bullyTWords = "Target " + "Taunt " + "Tears " + "Tease " + "Temper " + "Terrify "  + "Testy " + "Thoughtless " + "Thug " + "Thuggish " + "Tolerance " + "Tolerate " + "Torment " + "Tormentor " + "Trauma " + "Treacherous " + "Treatment " + "Trick " + "Trust ";
		String bullyUWords = "Uncivil " + "Uncouth " + "Unethical " + "Unfair " + "Unify " + "Unmannerly " + "Unreasonable " + "Unrefined " + "Unrelenting "  + "Unsavory " + "Unworthy ";
		String bullyVWords = "Verbal abuse " + "Vicious " + "Victim " + "Vigilance " + "Vile " + "Villainous "  + "Violence " + "Violent " + "Volatile ";
		String bullyWWords = "Warning" + "Wary " + "Waspish " + "Watchful " + "Weakness " + "Weary " + "Welfare " + "Whine " + "Why " + "Wicked " + "Wishy-washy " + "Words " + "Worry " + "Wound " + "Wrath " + "Wrong ";
		String bullyYWords = "Yelling " + "Youngsters " + "Youth ";
		String bullyZWords = "Zealot";

		
		CheckSameWords checker = new CheckSameWords();
		
		for (int i = 0; i < posts.size(); i++) {
			System.out.println(posts.get(i).getContent());
			if (checker.SameWordsCheck(bullyAWords, posts.get(i).getContent()) || checker.SameWordsCheck( bullyBWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyCWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyDWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyEWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyFWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyGWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyHWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyIWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyJWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyKWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyLWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyMWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyMWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyNWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyOWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyPWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyQWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyRWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullySWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyTWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyUWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyVWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyWWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyYWords, posts.get(i).getContent()) || checker.SameWordsCheck(bullyZWords, posts.get(i).getContent())) {
				bullyPosts.add(posts.get(i));
			}
			
		}
	
		
		int toShow = 4;
		if (request.getParameter("showNumber") != null) {
			toShow = Integer.parseInt((String) request.getParameter("showNumber"));
		}
		request.setAttribute("toShow", toShow);

		request.setAttribute("posts", bullyPosts);
        RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/bullyingReport.jsp");
        dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
