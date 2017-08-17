import { IRNSimInfo } from './RNSimInfo'
import 'react-native'

declare module 'react-native' {
  export interface NativeModulesStatic {
    RNSimInfo: IRNSimInfo
  }
}
