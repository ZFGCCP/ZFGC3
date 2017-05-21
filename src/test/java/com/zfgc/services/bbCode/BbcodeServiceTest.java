package com.zfgc.services.bbCode;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.zfgc.model.bbcode.BbCodeAttribute;
import com.zfgc.model.bbcode.BbCodeAttributeMode;
import com.zfgc.model.bbcode.BbcodeConfig;
import com.zfgc.services.bbcode.*;
import com.zfgc.model.bbcode.*;

public class BbcodeServiceTest {
	static BbcodeService service = new BbcodeService();
	static BbcodeConfig bbCodeQuote = null;
	static BbcodeConfig bbCodeCode = null;
	static BbcodeConfig bbCodeB = null;
	static BbcodeConfig bbCodeI = null;
	static BbcodeConfig bbCodeU = null;
	
	private static void initU(){
		bbCodeU = new BbcodeConfig();
		bbCodeU.setAllAttributeNamesAsString("");
		
		BbCodeAttributeMode mode0 = new BbCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-u'>");
		mode0.setCloseTag("</span>");
		
		List<BbCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeU.setAttributeConfig(new HashMap<>());
		bbCodeU.getAttributeConfig().put("",mode0);
		bbCodeU.setCode("u");
		bbCodeU.setProcessContentFlag(true);
		bbCodeU.setEndTag("</span>");
		
		bbCodeU.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("u", bbCodeU);
		service.bbCodeCounts.put("u", 0);
	}
	
	private static void initI(){
		bbCodeI = new BbcodeConfig();
		bbCodeI.setAllAttributeNamesAsString("");
		
		BbCodeAttributeMode mode0 = new BbCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-i'>");
		mode0.setCloseTag("</span>");
		
		List<BbCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeI.setAttributeConfig(new HashMap<>());
		bbCodeI.getAttributeConfig().put("",mode0);
		bbCodeI.setCode("i");
		bbCodeI.setProcessContentFlag(true);
		bbCodeI.setEndTag("</span>");
		
		bbCodeI.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("i", bbCodeI);
		service.bbCodeCounts.put("i", 0);
	}
	
	private static void initB(){
		bbCodeB = new BbcodeConfig();
		bbCodeB.setAllAttributeNamesAsString("");
		
		BbCodeAttributeMode mode0 = new BbCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-b'>");
		mode0.setCloseTag("</span>");
		
		List<BbCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeB.setAttributeConfig(new HashMap<>());
		bbCodeB.getAttributeConfig().put("",mode0);
		bbCodeB.setCode("b");
		bbCodeB.setProcessContentFlag(true);
		bbCodeB.setEndTag("</span>");
		
		bbCodeB.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("b", bbCodeB);
		service.bbCodeCounts.put("b", 0);
	}
	
	private static void initCode(){
		bbCodeCode = new BbcodeConfig();
		bbCodeCode.setAllAttributeNamesAsString("");
		
		BbCodeAttributeMode mode0 = new BbCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>");
		mode0.setCloseTag("</span>");
		
		List<BbCodeAttribute> mode0Att = new ArrayList<>();
		
		mode0.setAttributes(mode0Att);
		bbCodeCode.setAttributeConfig(new HashMap<>());
		bbCodeCode.getAttributeConfig().put("",mode0);
		bbCodeCode.setCode("code");
		bbCodeCode.setProcessContentFlag(false);
		bbCodeCode.setEndTag("</span>");
		
		bbCodeCode.getAttributeConfig().put("",mode0);
		
		service.validBbCodes.put("code", bbCodeCode);
		service.bbCodeCounts.put("code", 0);
	}
	
	private static void initQuote(){
		bbCodeQuote = new BbcodeConfig();
		bbCodeQuote.setAllAttributeNamesAsString("author=,link=,time=");
		
		BbCodeAttributeMode mode0 = new BbCodeAttributeMode();
		mode0.setOpenTag("<span class='bbcode-quote-header'><a href='{{1}}'>Authored by {{0}} at {{2}}</a></span><span class='bbcode-quote-block'>");
		mode0.setCloseTag("</span>");
		
		List<BbCodeAttribute> mode0Att = new ArrayList<>();
		BbCodeAttribute author = new BbCodeAttribute();
		author.setAttributeIndex("{{0}}");
		author.setDataType(AttributeDataType.TEXT);
		author.setName("author=");
		
		BbCodeAttribute link = new BbCodeAttribute();
		link.setAttributeIndex("{{1}}");
		link.setDataType(AttributeDataType.TEXT);
		link.setName("link=");
		
		BbCodeAttribute time = new BbCodeAttribute();
		time.setAttributeIndex("{{2}}");
		time.setDataType(AttributeDataType.TIMESTAMP);
		time.setName("time=");
		
		mode0Att.add(author);
		mode0Att.add(link);
		mode0Att.add(time);
		
		mode0.setAttributes(mode0Att);
		bbCodeQuote.setAttributeConfig(new HashMap<>());
		bbCodeQuote.getAttributeConfig().put("author=link=time=",mode0);
		bbCodeQuote.setCode("quote");
		bbCodeQuote.setProcessContentFlag(true);
		bbCodeQuote.setEndTag("</span>");
		
		BbCodeAttributeMode mode1 = new BbCodeAttributeMode();
		mode1.setOpenTag("<span class='bbcode-quote-header'>Authored by {{0}}</span><span class='bbcode-quote-block'>");
		mode1.setCloseTag("</span>");
		
		List<BbCodeAttribute> mode1Att = new ArrayList<>();
		BbCodeAttribute author1 = new BbCodeAttribute();
		author1.setAttributeIndex("{{0}}");
		author1.setDataType(AttributeDataType.TEXT);
		author1.setName("author=");
		mode1Att.add(author1);
		
		mode1.setAttributes(mode1Att);
		bbCodeQuote.getAttributeConfig().put("author=",mode1);
		
		service.validBbCodes.put("quote", bbCodeQuote);
		service.bbCodeCounts.put("quote", 0);
	}
	
	@BeforeClass
	public static void initialize(){
		initQuote();
		initCode();
		initB();
		initI();
		initU();
	}
	
	@Test
	public void parseTextMode1Code(){
		try {
			String result = service.parseText("[quote author=test]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by test</span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextMode0Code(){
		try {
			String result = service.parseText("[quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void processAttributesAllValidMode0(){
		String attributes = "author=MG-Zero link=thread/99 time=1494552503000";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray());
		
		assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>"));
	}
	
	@Test
	public void processAttributesAllValidMode1(){
		String attributes = "author=MG-Zero";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray());
		
		assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MG-Zero</span><span class='bbcode-quote-block'>"));
	}
	
	@Test
	public void processAttributesOneInvalid(){
		String attributes = "autor=test link=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void processAttributeskippedOne(){
		String attributes = "autor=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void processAttributesOutOfOrder(){
		String attributes = "link=test author=test time=1494552504";
		String result = service.processAttributes(bbCodeQuote, attributes.toCharArray());
		
		assertTrue(result.equals(attributes));
	}
	
	@Test
	public void parseTextQuoteEmbeddedMode0(){
		try {
			String result = service.parseText("[quote author=MG-Zero link=thread/99 time=1494552503000][quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote][/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'><span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span></span>"));
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void parseTextCode(){
		try {
			String result = service.parseText("[code]test[/code]");
			
			assertTrue(result.equals("<span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextCodeEmbedded(){
		try {
			String result = service.parseText("[code]test[code]test[quote][/code]");
			

			assertTrue(result.equals("<span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test[code]test[quote]</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextQuoteTwo(){
		try {
			String result = service.parseText("[quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote][quote author=MG-Zero link=thread/99 time=1494552503000]test[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span><span class='bbcode-quote-header'><a href='thread/99'>Authored by MG-Zero at 05/12/2017 01:28:23</a></span><span class='bbcode-quote-block'>test</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayClosing(){
		try {
			String result = service.parseText("This is my [/quote] house");
			
			assertTrue(result.equals("This is my [/quote] house"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayOpening(){
		try {
			String result = service.parseText("This is my [code] house");
			
			assertTrue(result.equals("This is my <span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'> house</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayClosingEmbedded(){
		try {
			String result = service.parseText("[quote author=MG-Zero]This is [/code] my house[/quote]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MG-Zero</span><span class='bbcode-quote-block'>This is [/code]</span> my house[/quote]"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayMismatched(){
		try {
			String result = service.parseText("[b][i]This is my house[/b][/i]");
			
			assertTrue(result.equals("<span class='bbcode-b'><span class='bbcode-i'>This is my house[/b]</span>[/i]</span>"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextStrayClosingOutside(){
		try {
			String result = service.parseText("[quote author=MG-Zero]This is my house[/quote][/code]");
			
			assertTrue(result.equals("<span class='bbcode-quote-header'>Authored by MG-Zero</span><span class='bbcode-quote-block'>This is my house</span>[/code]"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void parseTextMattyBoyTestBadInput(){
		try {
			String result = service.parseText("[b][code]test[/code][/b][b]hey[b]yo[b]wassup[b][i][u]bitch!!![/i][/u][/b][/b][/b][/b]  [i][u]yeah man[/i][/u] ");
			
			assertTrue(result.equals("<span class='bbcode-b'><span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test</span></span><span class='bbcode-b'>hey<span class='bbcode-b'>yo<span class='bbcode-b'>wassup<span class='bbcode-b'><span class='bbcode-i'><span class='bbcode-u'>bitch!!![/i]</span>[/u]</span></span></span></span></span>  <span class='bbcode-i'><span class='bbcode-u'>yeah man[/i]</span>[/u]</span> "));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void parseTextMattyBoyTestGoodInput(){
		try {
			String result = service.parseText("[b][code]test[/code][/b][b]hey[b]yo[b]wassup[b][i][u]bitch!!![/u][/i][/b][/b][/b][/b]  [i][u]yeah man[/u][/i] o");
			
			assertTrue(result.equals("<span class='bbcode-b'><span class='bbcode-code-header'>Code</span><span class='bbcode-code-block'>test</span></span><span class='bbcode-b'>hey<span class='bbcode-b'>yo<span class='bbcode-b'>wassup<span class='bbcode-b'><span class='bbcode-i'><span class='bbcode-u'>bitch!!!</span></span></span></span></span></span>  <span class='bbcode-i'><span class='bbcode-u'>yeah man</span></span> o"));
		} catch (NoSuchFieldException | SecurityException
				| IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
