import SwiftUI

@main
struct iOSApp: App {
    init() {
        startKoin()
    }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}

extension UIImageView {
    func load(url: URL) {
        DispatchQueue.global().async { [weak self] in
            if let data = try? Data(contentsOf: url) {
                if let image = UIImage(data: data) {
                    DispatchQueue.main.async {
                        self?.image = image
                    }
                }
            }
        }
    }
}
