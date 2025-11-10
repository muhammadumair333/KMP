//
//  SourceScreen.swift
//  iosApp
//
//  Created by Muhammad umair on 10/11/2025.
//  Copyright © 2025 orgName. All rights reserved.
//

import SwiftUI
import shared

extension SourceScreen {
    
    @MainActor
    class SourceViewModelWrapper: ObservableObject {
        
        let sourceViewModel: SourceViewModel
        
        
        init() {
            sourceViewModel = SourceInjector().sourceViewModel
            sourceState = sourceViewModel.sourcesState.value
        }
        
        @Published var sourceState: UIState<NSArray>
        
        func startObserving() {
            Task {
                for await sourceS in sourceViewModel.sourcesState {
                    self.sourceState = sourceS
                }
            }
        }
    }
}

struct SourceScreen : View {
    
    @ObservedObject private(set) var viewModel: SourceViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar(title: "Sources")
            
            if viewModel.sourceState.isLoading {
                Loader()
            }
            
            if let error = viewModel.sourceState.error {
                ErrorMessage(message: error)
            }
            else if let sources = viewModel.sourceState.result as? [Source], !sources.isEmpty {
                        ScrollView {
                            LazyVStack(spacing: 10) {
                                ForEach(sources, id: \.self) { source in
                                    SourceItemView(source: source)
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

struct SourceItemView: View {
    var source: Source
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            Text(source.name)
                .font(.title)
                .fontWeight(.bold)
            Text(source.description)
            Text(source.country + "|" + source.language).frame(maxWidth: .infinity, alignment: .trailing).foregroundStyle(.gray)
        }
        .padding(16)
    }
}

