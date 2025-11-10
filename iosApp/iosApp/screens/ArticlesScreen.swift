//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Muhammad umair on 01/11/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen {
    
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        
        let articlesViewModel: ArticlesViewModel
        
        
        init() {
            articlesViewModel = ArticlesInjector().articleViewModel
            articlesState = articlesViewModel.articlesState.value
        }
        
        @Published var articlesState: UIState<NSArray>
        
        func startObserving() {
            Task {
                for await articlesS in articlesViewModel.articlesState {
                    self.articlesState = articlesS
                }
            }
        }
    }
}

struct ArticlesScreen: View {
    
    @ObservedObject private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar(title: "Articles")
            
            if viewModel.articlesState.isLoading {
                Loader()
            }
            
            if let error = viewModel.articlesState.error {
                ErrorMessage(message: error)
            }
            else if let articles = viewModel.articlesState.result as? [Article], !articles.isEmpty {
                        ScrollView {
                            LazyVStack(spacing: 10) {
                                ForEach(articles, id: \.self) { article in
                                    ArticleItemView(article: article)
                                }
                            }
                        }
                    }
                }
                .onAppear {
                    viewModel.startObserving()
                }
    }
}



struct ArticleItemView: View {
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.urlToImage)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            Text(article.description)
            Text(article.publishedAt).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}

struct AppBar: View {
    let title: String
    var body: some View {
        Text(title)
            .font(.largeTitle)
            .fontWeight(.bold)
    }
}

struct Loader: View {
    var body: some View {
        ProgressView()
    }
}

struct ErrorMessage: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}
