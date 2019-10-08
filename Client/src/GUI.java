/**public class GUI {
    //currently not "graphic"
    private String menu = "1) Send Message\n2) Receive Message\n3) Close";
    Client client = null;
    public GUI(String address) {
        client = new Client(address,1337 );
    }
    public void DisplayMenu(){
        while(true){
            System.out.println(menu);
            client.running();
        }
    }
}
**/
