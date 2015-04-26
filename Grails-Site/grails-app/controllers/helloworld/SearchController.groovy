package helloworld

class SearchController {

    def index() { }
	
	def search(){
		Game game = Game.find { title == params.title }
		return [result: game]
	}
}
