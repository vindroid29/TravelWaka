import SwiftUI
import ComposeApp

@main
struct iOSApp: App {

    init() {

    }

    var body: some Scene {
        WindowGroup {
            ContentView()
                .ignoresSafeArea(edges: .all) // Add this line
                .ignoresSafeArea(.keyboard)
        }
    }
}
