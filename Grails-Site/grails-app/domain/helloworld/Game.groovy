
package helloworld
import grails.rest.*

@Resource(uri='/games', formats=['json', 'xml'])
class Game {
	String title
	String developer
	String ignrating
	int year
	
    static constraints = {
		title blank:false
    }
}
