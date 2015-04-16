@RestController
class Hello {
    @RequestMapping("/")
    String home() {
        [ id : 1, message : "Hello World!" ]
    }
}