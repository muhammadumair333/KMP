import SwiftUI
import shared

struct ContentView: View {

    @State private var shouldOpenAbout = false
    @State private var shouldOpenSource = false
	var body: some View {
        
        let articleScreen = ArticlesScreen(viewModel: .init())
        NavigationStack{
            articleScreen
                .toolbar{
                    ToolbarItemGroup{
                        
                        Button{
                            shouldOpenSource = true
                        } label: {
                            Label("Source", systemImage: "gearshape").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenSource){
                            SourceScreen(viewModel: .init())
                        }
                        
                        Button{
                            shouldOpenAbout = true
                        } label: {
                            Label("About", systemImage: "info.circle").labelStyle(.titleAndIcon)
                        }
                        .popover(isPresented: $shouldOpenAbout){
                            AboutScreen()
                        }
                        
                        
                    }
                }
        }.refreshable {
            articleScreen.viewModel.articlesViewModel.getArticles(forceFetch: true)
        }

	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}
