import SwiftUI


struct ContentView: View {
    @ObservedObject var viewModel = ContentViewViewModel()

    var body: some View {
        NavigationView{
            List(viewModel.beers,id:\.id){ beer in
            
            BeerView(beer: beer)
            
            
        }.navigationBarTitle(Text("Beers"),displayMode: NavigationBarItem.TitleDisplayMode.large)}
            .onAppear {
         
            viewModel.fetchBeer()
           
        }
    } }
    

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
