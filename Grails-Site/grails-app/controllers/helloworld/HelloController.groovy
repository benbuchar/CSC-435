package helloworld

import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.node.JsonNodeFactory
import com.fasterxml.jackson.databind.node.ObjectNode

class HelloController {

    def index() {
		
		return [result: "Enter A Game:"]
	}
	def save(){
		String titleWithPluses = params.title.replaceAll("[\\W]", "+")
		URL url = new URL("https://videogamesrating.p.mashape.com/get.php?count=5&game=" + titleWithPluses)
		URLConnection con = url.openConnection()
		con.setRequestProperty("X-Mashape-Key", "/**KEY**/")
		InputStream is = con.getInputStream()
		Scanner sc = new Scanner(new InputStreamReader(is))
		String line = sc.nextLine()
		Scanner lineSc = new Scanner(line)
		lineSc.useDelimiter("\"")
		String s = ""
		while(lineSc.hasNext()){
			if(lineSc.next().equals("score")){
				lineSc.next()
				s += lineSc.next()
				break;
			}
		}		
		def game = new Game(params)
		game.ignrating = s
		game.save()
		render (view: "index")
	}
	
	
}
