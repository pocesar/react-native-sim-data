import { RNSimData } from './index'
import 'react-native'

declare module 'react-native' {
  export interface NativeModulesStatic {
    RNSimDataModule: RNSimData
  }
}
