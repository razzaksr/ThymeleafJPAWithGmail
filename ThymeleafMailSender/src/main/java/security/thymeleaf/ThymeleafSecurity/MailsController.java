package security.thymeleaf.ThymeleafSecurity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MailsController 
{
	@Autowired
	MailsService serv;
	
	List<Mails> got;
	
	@RequestMapping("/")
	public String gather(Model model)
	{
		got=serv.gatherAll();
		model.addAttribute("record", got);
		return "list";
	}
	
	@RequestMapping("/sendmail/{id}")
	public String each(@PathVariable("id") int id, Model model)
	{
		Mails m=serv.receive(id);
		serv.sendMail(m);
		model.addAttribute("info","Mail has sent to "+m.getName());
		return "forward:/";
	}
}
