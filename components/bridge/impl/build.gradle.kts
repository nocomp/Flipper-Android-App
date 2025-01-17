plugins {
    androidLibrary
    id("com.squareup.anvil")
    kotlin("kapt")
}

dependencies {
    implementation(projects.components.core.log)
    implementation(projects.components.core.ktx)

    implementation(projects.components.bridge.api)
    implementation(projects.components.bridge.protobuf)

    implementation(libs.kotlin.coroutines)
    implementation(Libs.ANNOTATIONS)
    implementation(Libs.CORE_KTX)
    implementation(Libs.APPCOMPAT)

    implementation(Libs.NORDIC_BLE_SCAN)
    implementation(Libs.NORDIC_BLE)
    implementation(Libs.NORDIC_BLE_KTX)
    implementation(Libs.NORDIC_BLE_COMMON)

    implementation(libs.dagger)
    kapt(libs.dagger.kapt)

    implementation(Libs.FASTUTIL)

    testImplementation(projects.components.core.test)
    testImplementation(TestingLib.JUNIT)
    testImplementation(TestingLib.MOCKITO)
    testImplementation(TestingLib.ANDROIDX_TEST_EXT_JUNIT)
    testImplementation(TestingLib.ROBOELECTRIC)
    testImplementation(TestingLib.LIFECYCLE)
    testImplementation(libs.kotlin.coroutines.test)
}
