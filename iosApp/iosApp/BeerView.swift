//
//  BeerView.swift
//  iosApp
//
//  Created by Lavoro Spindox on 16/04/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared
import URLImage

struct BeerView: View {
    var beer:Beer
    
    var body: some View {
        let url = URL(string: beer.imageUrl)

        HStack{
            URLImage(url: url!,
                     content: { image in
                        image
                             .resizable()
                            .aspectRatio(contentMode: .fit)
                            .frame(width: 80.0, height: 80.0)
                     })
            VStack(alignment:.leading){
                Text(beer.name)
                
            }
        }
    }
}

struct BeerView_Previews: PreviewProvider {
    static var previews: some View {
        BeerView(beer: Beer(id: 122, imageUrl:"https://images.punkapi.com/v2/keg.png", name: "Beer", description: "String", abv: 12.2, ibu: 12, firstBrewed: "", brewersTips: ""))
    }
}
